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
import io.github.evolutionThroughCraft.common.arch.orchestrators.SimpleOperation;
import io.github.evolutionThroughCraft.common.service.main.api.Balance;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dwin
 */
@Component
@Getter @Setter
public class GetOperation extends SimpleOperation<Long, AccountForm> {

    @Autowired    
    private AccountTransactionClient transactionClient;

    @Autowired
    private AccountRepository accountRepo;

    @Autowired    
    private Parser parser;

    @Override
    public AccountForm perform(Long accountId) {
        AccountEntity account = getAccountRepo().getOne(accountId);
        Balance balance = getTransactionClient().getAccountBalance(accountId);
        
        AccountForm form = getParser().getAccountForm(account, balance);
        return form;
    }
    
}
