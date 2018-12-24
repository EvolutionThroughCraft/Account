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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dwin
 */
@Component
public class GetOperation {
    
    private AccountTransactionClient transactionClient;
    private AccountRepository accountRepo;
    private Parser parser;
    
    public AccountForm perform(Long accountId) {
        AccountEntity account = getAccountRepo().getOne(accountId);
        Balance balance = getTransactionClient().getAccountBalance(accountId);
        
        AccountForm form = getParser().getAccountForm(account, balance);
        return form;
    }
    
    ///////////////////////////////
    ////   getters + setters   ////
    ///////////////////////////////

    public AccountTransactionClient getTransactionClient() {
        return transactionClient;
    }

    @Autowired
    public void setTransactionClient(AccountTransactionClient transactionClient) {
        this.transactionClient = transactionClient;
    }

    public AccountRepository getAccountRepo() {
        return accountRepo;
    }

    @Autowired
    public void setAccountRepo(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    public Parser getParser() {
        return parser;
    }

    @Autowired    
    public void setParser(Parser parser) {
        this.parser = parser;
    }

}
