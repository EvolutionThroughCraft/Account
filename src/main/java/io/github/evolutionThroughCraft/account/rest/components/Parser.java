/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.account.rest.components;

import io.github.evolutionThroughCraft.account.models.AccountEntity;
import io.github.evolutionThroughCraft.account.models.AccountForm;
import io.github.evolutionThroughCraft.common.service.main.api.Account;
import io.github.evolutionThroughCraft.common.service.main.api.Transaction;
import io.github.evolutionThroughCraft.common.service.main.api.pojo.TransactionPojo;
import org.springframework.stereotype.Component;

/**
 *
 * @author dwin
 */
@Component
public class Parser {
    
    public AccountEntity getAccountEntity(AccountForm form) {        
        AccountEntity entity = new AccountEntity();
        entity.setAccountId(form.getAccountId());
        entity.setDisplayName(form.getDisplayName());
        entity.setUserName(form.getUserName());
        entity.setCreateUser(form.getCreateUser());
        entity.setUpdateUser(form.getUpdateUser());
        return entity;
    }
    
    public TransactionPojo getTransaction(AccountForm form, Long actId) {
        TransactionPojo pojo = new TransactionPojo();
        pojo.setAmount(form.getBalance());
        pojo.setCreateUser(form.getCreateUser());
        pojo.setUpdateUser(form.getUpdateUser());
        pojo.setCreditorId(actId);
        return pojo;
    }
    
    public AccountForm getAccountForm(AccountEntity entity, Integer balance) {
        AccountForm form = new AccountForm();
        form.setAccountId(form.getAccountId());
        form.setDisplayName(form.getDisplayName());
        form.setUserName(form.getUserName());
        form.setCreateUser(form.getCreateUser());
        form.setUpdateUser(form.getUpdateUser());  
        form.setUpdateTime(entity.getUpdateTime());
        form.setCreateTime(entity.getCreateTime());
        form.setBalance(balance);
        return form;
    }
}
