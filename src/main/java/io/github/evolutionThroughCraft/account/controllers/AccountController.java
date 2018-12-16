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
import io.github.evolutionThroughCraft.common.service.main.utils.ResourceUtility;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

/**
 *
 * @author dwin
 */
@RestController
@RequestMapping("/accounts")
public class AccountController {
    
    @Autowired
    private AccountRepository accountRepo;
    
    @Autowired
    private CreateOperation createOperation;
    
    @GetMapping
    public List<AccountEntity> findAll() {
        return accountRepo.findAll();
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountEntity createAccount(@Valid @RequestBody AccountForm form) {
//        ResourceUtility.ensureResource(form);
//        AccountEntity account = new AccountEntity(form);
//        return accountRepo.save(account);
        
        return createOperation.perform(form);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountEntity updateAccount(
                        @PathVariable("id") Long id, 
                        @Valid @RequestBody AccountEntity account
    ) {
        ResourceUtility.ensureResource(account);
        ResourceUtility.ensureResource(accountRepo.getOne(id));
        ResourceUtility.ensureIdsEqual(id, account.getAccountId());
        return accountRepo.save(account);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@PathVariable("id") Long id) {
        accountRepo.deleteById(id);
    }
}
