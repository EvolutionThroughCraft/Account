/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.account.controllers;

import io.github.evolutionThroughCraft.account.models.AccountEntity;
import io.github.evolutionThroughCraft.account.models.AccountForm;
import io.github.evolutionThroughCraft.account.repo.AccountRepository;
import io.github.evolutionThroughCraft.account.rest.CreateOperation;
import io.github.evolutionThroughCraft.account.rest.GetOperation;
import io.github.evolutionThroughCraft.common.service.main.routes.AccountRoutes;
import io.github.evolutionThroughCraft.common.service.main.utils.ResourceUtility;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.apache.log4j.Logger;
/**
 *
 * @author dwin
 */
@RestController
@RequestMapping
public class AccountController implements AccountRoutes {
    
    private static final Logger scribe = Logger.getLogger(AccountController.class);
    
    @Autowired
    private AccountRepository accountRepo;
    
    @Autowired
    private CreateOperation createOperation;
    
    @Autowired
    private GetOperation getOperation;
    
    @GetMapping(GET_ALL_ACCOUNT_PATH)
    public List<AccountEntity> findAll() {
        return accountRepo.findAll();
    }
    
    @GetMapping(GET_ACCOUNT_PATH)
    public AccountForm getAccount(@PathVariable(ACCOUNT_ID_VAR) Long id) {
        scribe.debug("the id:" + id);
        return getOperation.run(id);
    }
    
    @PostMapping(POST_ACCOUNT_PATH)
    @ResponseStatus(HttpStatus.CREATED)
    public AccountEntity createAccount(@Valid @RequestBody AccountForm form) {
//        ResourceUtility.ensureResource(form);
//        AccountEntity account = new AccountEntity(form);
//        return accountRepo.save(account);
        scribe.debug("the form:" + form);
        return createOperation.run(form);
    }
    
    @PutMapping(PUT_ACCOUNT_PATH)
    @ResponseStatus(HttpStatus.OK)
    public AccountEntity updateAccount(
                        @PathVariable(ACCOUNT_ID_VAR) Long id, 
                        @Valid @RequestBody AccountEntity account
    ) {
        ResourceUtility.ensureResource(account);
        ResourceUtility.ensureResource(accountRepo.getOne(id));
        ResourceUtility.ensureIdsEqual(id, account.getAccountId());
        return accountRepo.save(account);
    }
    
    @DeleteMapping(DELETE_ACCOUNT_PATH)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@PathVariable(ACCOUNT_ID_VAR) Long id) {
        accountRepo.deleteById(id);
    }
}
