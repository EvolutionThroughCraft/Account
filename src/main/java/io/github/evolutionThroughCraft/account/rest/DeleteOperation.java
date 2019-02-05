/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.account.rest;

import io.github.evolutionThroughCraft.account.repo.AccountRepository;
import io.github.evolutionThroughCraft.account.rest.components.AccountTransactionClient;
import io.github.evolutionThroughCraft.common.arch.orchestrators.SimpleOperation;
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
public class DeleteOperation extends SimpleOperation<Long, Boolean> {
    
    @Autowired    
    private AccountTransactionClient transactionClient;

    @Autowired
    private AccountRepository accountRepo;
    
    @Override
    public Boolean perform(Long actId) {
        getAccountRepo().deleteById(actId);
        getTransactionClient().deleteAccountTransactions(actId);
        return true;
    }
}
