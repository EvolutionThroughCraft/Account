/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.account.rest;

import io.github.evolutionThroughCraft.account.models.AccountForm;
import io.github.evolutionThroughCraft.common.arch.contracts.Contract;
import io.github.evolutionThroughCraft.common.service.main.utils.ResourceUtility;
import org.springframework.stereotype.Component;

/**
 *
 * @author dwin
 */
@Component
public class CreateContract implements Contract<AccountForm> {
    
    @Override
    public void validate(AccountForm form) {
        ResourceUtility.ensureResource(form, "AccountForm Missing");
        ResourceUtility.ensureResource(form.getUserName(), "UserName Missing");
        ResourceUtility.ensureResource(form.getDisplayName(), "DisplayName Missing");
        ResourceUtility.ensureResource(form.getCreateUser(), "CreateUser Missing");
        ResourceUtility.ensureResource(form.getUpdateUser(), "UpdateUser Missing");
        ResourceUtility.ensureResource(form.getBalance(), "Starting Balance Missing");        
    }
}
