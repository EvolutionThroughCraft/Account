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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dwin
 */
@Component
public class CreateOperation {

    private AccountRepository accountRepo;
    private CreateContract contract;    
    private Parser parser;
    private AccountTransactionClient transactionClient;
    
    public AccountEntity perform(AccountForm form) {
        getContract().validate(form);
        AccountEntity act = getParser().getAccountEntity(form);
        AccountEntity saved = getAccountRepo().save(act);
        TransactionPojo transaction = getParser().getTransaction(form, saved.getAccountId());
        getTransactionClient().postTransaction(transaction);
        return saved;
    }

    ///////////////////////////////
    ////   getters + setters   ////
    ///////////////////////////////
    
    public AccountRepository getAccountRepo() {
        return accountRepo;
    }

    @Autowired
    public void setAccountRepo(AccountRepository accountRepo) {
        this.accountRepo = accountRepo;
    }

    public CreateContract getContract() {
        return contract;
    }

    @Autowired    
    public void setContract(CreateContract contract) {
        this.contract = contract;
    }

    public Parser getParser() {
        return parser;
    }

    @Autowired
    public void setParser(Parser parser) {
        this.parser = parser;
    }

    public AccountTransactionClient getTransactionClient() {
        return transactionClient;
    }

    @Autowired
    public void setTransactionClient(AccountTransactionClient transactionClient) {
        this.transactionClient = transactionClient;
    }
}
