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
import io.github.evolutionThroughCraft.account.rest.DeleteOperation;
import io.github.evolutionThroughCraft.account.rest.GetAllOperation;
import io.github.evolutionThroughCraft.account.rest.GetOperation;
import io.github.evolutionThroughCraft.account.rest.UpdateOperation;
import io.github.evolutionThroughCraft.common.service.main.models.ArgumentPlaceholder;
import io.github.evolutionThroughCraft.common.service.main.routes.AccountRoutes;
import java.util.List;
import javax.validation.Valid;
import lombok.Getter;
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
@Getter
public class AccountController implements AccountRoutes {
    
    private static final Logger scribe = Logger.getLogger(AccountController.class);
    
    @Autowired
    private CreateOperation createOperation;
    
    @Autowired
    private GetOperation getOperation;
    
    @Autowired
    private DeleteOperation deleteOperation;
    
    @Autowired
    private UpdateOperation updateOperation;
    
    @Autowired
    private GetAllOperation getAllOperation;
    
    @GetMapping(GET_ALL_ACCOUNT_PATH)
    public List<AccountEntity> findAll() {
        return getGetAllOperation().run(new ArgumentPlaceholder());
    }
    
    @GetMapping(GET_ACCOUNT_PATH)
    public AccountForm getAccount(@PathVariable(ACCOUNT_ID_VAR) Long id) {
        scribe.debug("the id:" + id);
        return getGetOperation().run(id);
    }
    
    @PostMapping(POST_ACCOUNT_PATH)
    @ResponseStatus(HttpStatus.CREATED)
    public AccountEntity createAccount(@Valid @RequestBody AccountForm form) {
        scribe.debug("the form:" + form);
        return getCreateOperation().run(form);
    }
    
    @PutMapping(PUT_ACCOUNT_PATH)
    @ResponseStatus(HttpStatus.OK)
    public AccountEntity updateAccount(
                        @PathVariable(ACCOUNT_ID_VAR) Long id, 
                        @Valid @RequestBody AccountForm account
    ) {
        account.setAccountId(id);
        return getUpdateOperation().run(account);
    }
    
    @DeleteMapping(DELETE_ACCOUNT_PATH)
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@PathVariable(ACCOUNT_ID_VAR) Long id) {
        getDeleteOperation().run(id);
    }
}
