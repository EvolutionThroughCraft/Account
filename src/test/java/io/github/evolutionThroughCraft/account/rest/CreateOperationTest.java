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
import io.github.evolutionThroughCraft.common.service.main.api.pojo.TransactionPojo;
import io.github.evolutionThroughCraft.common.service.main.models.ResourceNotFoundException;
import java.util.Calendar;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
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
public class CreateOperationTest {
    
    // CUT
    private CreateOperation classUnderTest;
    
    // injected mocks
    private AccountRepository mockRepo;
    private AccountTransactionClient mockClient;
    
    // live injects
    private Parser injectedParser;
    private CreateContract injectedContract;

    // form arg
    private AccountForm form;
    private Integer formBalance;
    private String formUserName;
    private String formDisplayName;
    private String formCreateUser;
    private String formUpdateUser;
    
    // mock args
    private Long mockAccountId;
    private Date mockCreateTime;
    private Date mockUpdateTime;
    private AccountEntity repoRtn;
    
    @Rule
    public ExpectedException exceptionState = ExpectedException.none();
    
    
    @Before
    public void setUp() {
        // form var
        formBalance = 1000;
        formUserName = "Bruce Wayne";
        formDisplayName = "Batman";
        formCreateUser = "Ron";
        formUpdateUser = "Evan";
        
        // valid form
        form = new AccountForm();
        form.setBalance(formBalance);
        form.setUserName(formUserName);
        form.setDisplayName(formDisplayName);
        form.setCreateUser(formCreateUser);
        form.setUpdateUser(formUpdateUser);

        // mock var
        mockAccountId = 1337L;
    
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        mockCreateTime = cal.getTime();
        cal.add(Calendar.DATE, 2);
        mockUpdateTime = cal.getTime();
        
        // repo mock        
        repoRtn = new AccountEntity();
        repoRtn.setAccountId(mockAccountId);
        repoRtn.setUserName(formUserName);
        repoRtn.setDisplayName(formDisplayName);
        repoRtn.setCreateUser(formCreateUser);
        repoRtn.setCreateTime(mockCreateTime);
        repoRtn.setUpdateUser(formUpdateUser);
        repoRtn.setUpdateTime(mockUpdateTime);
        
        mockRepo = mock(AccountRepository.class);
        when(mockRepo.save(any(AccountEntity.class))).thenReturn(repoRtn);
        
        // client mock
        mockClient = mock(AccountTransactionClient.class);                
        
        // injects
        injectedParser = new Parser();
        injectedContract = new CreateContract();

        // CUT
        classUnderTest = new CreateOperation();
        classUnderTest.setAccountRepo(mockRepo);
        classUnderTest.setContract(injectedContract);
        classUnderTest.setParser(injectedParser);
        classUnderTest.setTransactionClient(mockClient);
        
    }

    @Test
    public void delegatesToAccountRepo_CorrectAtrib() {
        // setup
        
        // measurements
        ArgumentCaptor<AccountEntity> repoArg = ArgumentCaptor.forClass(AccountEntity.class);
        
        // tested act
        classUnderTest.run(form);
        
        // assertions
        verify(mockRepo, times(1)).save(repoArg.capture());
        AccountEntity passedEntity = repoArg.getValue();
        
        //// set atrib
        assertEquals("user name", formUserName, passedEntity.getUserName());
        assertEquals("display name", formDisplayName, passedEntity.getDisplayName());
        assertEquals("update user", formUpdateUser, passedEntity.getUpdateUser());
        assertEquals("create user", formCreateUser, passedEntity.getCreateUser());
        //// unset atrib
        assertNull("account id", passedEntity.getAccountId());
        assertNull("update time", passedEntity.getUpdateTime());
        assertNull("create time", passedEntity.getCreateTime());
    }
    
    @Test
    public void delegateToTransactionClient_CorrectAtrib() {
        // setup
        
        // measurements
        ArgumentCaptor<TransactionPojo> clientArg = ArgumentCaptor.forClass(TransactionPojo.class);
        
        // tested act
        classUnderTest.run(form);
        
        // assertions
        verify(mockClient, times(1)).postTransaction(clientArg.capture());
        TransactionPojo passedPojo = clientArg.getValue();
        
        //// set atrib
        assertEquals("creditor id", mockAccountId, passedPojo.getCreditorId());
        assertEquals("amount", formBalance, passedPojo.getAmount());
        assertEquals("create user", formCreateUser, passedPojo.getCreateUser());
        assertEquals("update user", formUpdateUser, passedPojo.getUpdateUser());
        //// unset atrib
        assertNull("transaction id", passedPojo.getTransactionId());
        assertNull("debitor id", passedPojo.getDebitorId());
        assertNull("create time", passedPojo.getCreateTime());
        assertNull("update time", passedPojo.getUpdateTime());        
    }
    
    @Test
    public void returnsPopulatedEntity() {
        // setup        

        // tested act
        AccountEntity rtnEntity = classUnderTest.run(form);
        
        // assertions
        //// set atrib
        assertEquals("user name", formUserName, rtnEntity.getUserName());
        assertEquals("display name", formDisplayName, rtnEntity.getDisplayName());
        assertEquals("update user", formUpdateUser, rtnEntity.getUpdateUser());
        assertEquals("create user", formCreateUser, rtnEntity.getCreateUser());
        assertEquals("account id", mockAccountId, rtnEntity.getAccountId());
        assertEquals("update time", mockUpdateTime, rtnEntity.getUpdateTime());
        assertEquals("create time", mockCreateTime, rtnEntity.getCreateTime());
    }
    
    @Test
    public void formMissing_errors() {
        // setup
        form = null;

        // expectations
        exceptionState.expect(ResourceNotFoundException.class);
        exceptionState.expectMessage("AccountForm Missing");
       
        // tested act
        classUnderTest.run(form);
    }
    
    @Test
    public void balanceMissing_errors() {
        // setup
        form.setBalance(null);

        // expectations
        exceptionState.expect(ResourceNotFoundException.class);
        exceptionState.expectMessage("Starting Balance Missing");
       
        // tested act
        classUnderTest.run(form);
    }
    
    @Test
    public void userNameMissing_errors() {
        // setup
        form.setUserName(null);

        // expectations
        exceptionState.expect(ResourceNotFoundException.class);
        exceptionState.expectMessage("UserName Missing");
       
        // tested act
        classUnderTest.run(form);
    }
    
    @Test
    public void displayNameMissing_errors() {
        // setup
        form.setDisplayName(null);

        // expectations
        exceptionState.expect(ResourceNotFoundException.class);
        exceptionState.expectMessage("DisplayName Missing");
       
        // tested act
        classUnderTest.run(form);
    }
    
    @Test
    public void createUserMissing_errors() {
        // setup
        form.setCreateUser(null);

        // expectations
        exceptionState.expect(ResourceNotFoundException.class);
        exceptionState.expectMessage("CreateUser Missing");
       
        // tested act
        classUnderTest.run(form);
    }
    
    @Test
    public void updateUserMissing_errors() {
        // setup
        form.setUpdateUser(null);

        // expectations
        exceptionState.expect(ResourceNotFoundException.class);
        exceptionState.expectMessage("UpdateUser Missing");
       
        // tested act
        classUnderTest.run(form);
    }
    
}
