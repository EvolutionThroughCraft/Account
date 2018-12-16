/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.account.rest;

import io.github.evolutionThroughCraft.account.models.AccountEntity;
import io.github.evolutionThroughCraft.account.models.AccountForm;
import io.github.evolutionThroughCraft.account.repo.AccountRepository;
import io.github.evolutionThroughCraft.account.rest.components.LocalTransactionClient;
import io.github.evolutionThroughCraft.account.rest.components.Parser;
import io.github.evolutionThroughCraft.common.service.main.api.pojo.TransactionPojo;
import io.github.evolutionThroughCraft.common.service.main.clients.TransactionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dwin
 */
@Component
public class CreateOperation {

    @Autowired
    private AccountRepository accountRepo;

    @Autowired
    private CreateContract contract;
    
    @Autowired
    private Parser parser;
    
//    @Autowired
//    private TransactionClient transactionClient;

    @Autowired
    private LocalTransactionClient transactionClient;
    
    public AccountEntity perform(AccountForm form) {
        contract.validate(form);
        AccountEntity act = parser.getAccountEntity(form);
        AccountEntity saved = accountRepo.save(act);
        TransactionPojo transaction = parser.getTransaction(form, saved.getAccountId());
        transactionClient.postTransaction(transaction);
        return saved;
    }
}
