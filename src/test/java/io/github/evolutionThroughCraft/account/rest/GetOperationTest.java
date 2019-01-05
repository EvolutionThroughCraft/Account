/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.account.rest;

import io.github.evolutionThroughCraft.account.models.AccountEntity;
import io.github.evolutionThroughCraft.account.models.AccountForm;
import io.github.evolutionThroughCraft.account.repo.AccountRepository;
import io.github.evolutionThroughCraft.account.rest.components.AccountTransactionClient;
import io.github.evolutionThroughCraft.account.rest.components.Parser;
import io.github.evolutionThroughCraft.common.service.main.api.Balance;
import io.github.evolutionThroughCraft.common.service.main.api.pojo.BalancePojo;
import java.util.Calendar;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.ArgumentCaptor;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 *
 * @author dwin
 */
public class GetOperationTest {
    
    // CUT
    private GetOperation classUnderTest;
    
    // injected mocks
    private AccountRepository mockRepo;
    private AccountTransactionClient mockClient;
    
    // live injects
    private Parser injectedParser;
    
    // form var
    private Long formAccountId;
    
    // mock args
    private Integer mockBalance;
    private String mockUserName;
    private String mockDisplayName;
    private String mockCreateUser;    
    private Date mockCreateTime;
    private String mockUpdateUser;
    private Date mockUpdateTime;
    
    // mock rtns
    private AccountEntity repoRtn;
    private Balance clientRtn;
    
    @Before
    public void setUp() {
        // form var
        formAccountId = 357L;
        
        // mock var
        mockBalance = 300;
        mockUserName = "Superman";
        mockDisplayName = "Clark Kent";
        mockCreateUser = "Steven";
        mockUpdateUser = "Colbert";
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -4);
        mockCreateTime = cal.getTime();
        cal.add(Calendar.DATE, 2);
        mockUpdateTime = cal.getTime();
        
        // repo mock        
        repoRtn = new AccountEntity();
        repoRtn.setAccountId(formAccountId);
        repoRtn.setUserName(mockUserName);
        repoRtn.setDisplayName(mockDisplayName);
        repoRtn.setCreateUser(mockCreateUser);
        repoRtn.setCreateTime(mockCreateTime);
        repoRtn.setUpdateUser(mockUpdateUser);
        repoRtn.setUpdateTime(mockUpdateTime);
        
        mockRepo = mock(AccountRepository.class);
        when(mockRepo.getOne(formAccountId)).thenReturn(repoRtn);        

        // client mock
        BalancePojo balRtn = new BalancePojo();
        balRtn.setAmount(mockBalance);
        clientRtn = balRtn;
        
        mockClient = mock(AccountTransactionClient.class);
        when(mockClient.getAccountBalance(formAccountId)).thenReturn(clientRtn);
    
        // injects
        injectedParser = new Parser();

        // CUT
        classUnderTest = new GetOperation();
        classUnderTest.setAccountRepo(mockRepo);
        classUnderTest.setTransactionClient(mockClient);
        classUnderTest.setParser(injectedParser);
    }
    

    @Test
    public void delegatesToAccountRepo_CorrectCall() {    
        // measurements
        ArgumentCaptor<Long> repoArg = ArgumentCaptor.forClass(Long.class);
    
        // tested act
        classUnderTest.run(formAccountId);
        
        // assertions
        verify(mockRepo, times(1)).getOne(repoArg.capture());
        
        assertEquals("account id", formAccountId, repoArg.getValue());
    }    

    @Test
    public void delegatesToAccountClient_CorrectCall() {    
        // measurements
        ArgumentCaptor<Long> clientArg = ArgumentCaptor.forClass(Long.class);
    
        // tested act
        classUnderTest.run(formAccountId);
        
        // assertions
        verify(mockClient, times(1)).getAccountBalance(clientArg.capture());
        
        assertEquals("account id", formAccountId, clientArg.getValue());
    }
    
    @Test
    public void returnsPopulatedForm() {
        // setup
        
        // tested act
        AccountForm rtnForm = classUnderTest.run(formAccountId);
        
        // assertions
        //// set atrib
        assertEquals("account id", formAccountId, rtnForm.getAccountId());
        assertEquals("display name", mockDisplayName, rtnForm.getDisplayName());
        assertEquals("user name", mockUserName, rtnForm.getUserName());
        assertEquals("create user", mockCreateUser, rtnForm.getCreateUser());
        assertEquals("update user", mockUpdateUser, rtnForm.getUpdateUser());
        assertEquals("create time", mockCreateTime, rtnForm.getCreateTime());
        assertEquals("update time", mockUpdateTime, rtnForm.getUpdateTime());
        assertEquals("balance", mockBalance, rtnForm.getBalance());
    }
}
