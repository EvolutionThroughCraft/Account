/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.account.rest;

import io.github.evolutionThroughCraft.account.models.AccountEntity;
import io.github.evolutionThroughCraft.account.models.AccountForm;
import io.github.evolutionThroughCraft.account.repo.AccountRepository;
import io.github.evolutionThroughCraft.account.rest.components.Parser;
import io.github.evolutionThroughCraft.common.service.main.api.Balance;
import io.github.evolutionThroughCraft.common.service.main.clients.TransactionClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dwin
 */
@Component
public class GetOperation {
    
    @Autowired
    private TransactionClient transactionClient;
    
    @Autowired
    private AccountRepository accountRepo;
            
    @Autowired
    private Parser parser;
    
    public AccountForm perform(Long accountId) {
        AccountEntity account = accountRepo.getOne(accountId);
        Balance balance = transactionClient.getAccountBalance(accountId);
        
        AccountForm form = parser.getAccountForm(account, balance);
        return form;
    }
}
