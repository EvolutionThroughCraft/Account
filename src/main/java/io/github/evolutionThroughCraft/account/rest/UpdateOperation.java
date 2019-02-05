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
import io.github.evolutionThroughCraft.common.arch.orchestrators.ContractOperation;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 *
 * @author dwin
 */
@Component
@Getter
public class UpdateOperation extends ContractOperation<AccountForm, AccountEntity, UpdateContract> {
    
    @Autowired @Qualifier("accountUpdate")
    private UpdateContract contract;
    
    @Autowired
    private AccountRepository accountRepo;
    
    @Autowired
    private Parser parser;
    
    @Override
    public AccountEntity perform(AccountForm form) {
        AccountEntity entity = getParser().getAccountEntity(form);
        return getAccountRepo().save(entity);
    }
}
