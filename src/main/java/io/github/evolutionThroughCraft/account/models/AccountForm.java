/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.account.models;

import io.github.evolutionThroughCraft.common.service.main.api.Account;
import io.github.evolutionThroughCraft.common.service.main.api.pojo.AccountPojo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author dwin
 */
@Getter @Setter
@NoArgsConstructor
public class AccountForm extends AccountPojo implements Account {
    
    private Integer balance;

    
    public AccountForm(AccountEntity entity) {
        super();
        setAccountId(entity.getAccountId());
        setUserName(entity.getUserName());
        setDisplayName(entity.getDisplayName());
        setCreateTime(entity.getCreateTime());
        setCreateUser(entity.getCreateUser());
        setUpdateTime(entity.getUpdateTime());
        setUpdateUser(entity.getUpdateUser());
    }
    
    
}
