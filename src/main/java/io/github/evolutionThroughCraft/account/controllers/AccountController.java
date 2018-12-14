/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.account.controllers;

import io.github.evolutionThroughCraft.account.models.Account;
import io.github.evolutionThroughCraft.account.repo.AccountRepository;
import io.github.evolutionThroughCraft.common.service.main.utils.ResourceUtility;
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
    
    @GetMapping
    public Page<Account> findAll(Pageable pageable) {
        return accountRepo.findAll(pageable);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Account createAccount(@Valid @RequestBody Account account) {
        ResourceUtility.ensureResource(account);
        return accountRepo.save(account);
    }
    
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Account updateAccount(
                        @PathVariable("id") Long id, 
                        @Valid @RequestBody Account account
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
