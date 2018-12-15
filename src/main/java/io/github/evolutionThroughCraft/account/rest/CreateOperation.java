/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.account.rest;

import io.github.evolutionThroughCraft.account.models.AccountEntity;
import io.github.evolutionThroughCraft.account.models.AccountForm;
import io.github.evolutionThroughCraft.account.repo.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author dwin
 */
public class CreateOperation {
    @Autowired
    private AccountRepository accountRepo;

    public void perform(AccountForm form) {
        CreateContract.validate(form);
        AccountEntity account = new AccountEntity(form);
        accountRepo.save(account);
    }
}
