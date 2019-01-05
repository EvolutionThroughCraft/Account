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
import io.github.evolutionThroughCraft.common.arch.orchestrators.ContractOperation;
import io.github.evolutionThroughCraft.common.service.main.api.pojo.TransactionPojo;
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
public class CreateOperation extends ContractOperation<AccountForm, AccountEntity, CreateContract>{

    @Autowired
    private AccountRepository accountRepo;

    @Autowired    
    private CreateContract contract;    

    @Autowired
    private Parser parser;

    @Autowired
    private AccountTransactionClient transactionClient;

    @Override
    public AccountEntity perform(AccountForm form) {
        AccountEntity act = getParser().getAccountEntity(form);
        AccountEntity saved = getAccountRepo().save(act);
        TransactionPojo transaction = getParser().getTransaction(form, saved.getAccountId());
        getTransactionClient().postTransaction(transaction);
        return saved;
    }
}
