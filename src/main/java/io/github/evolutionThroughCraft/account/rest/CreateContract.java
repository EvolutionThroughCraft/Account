/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.account.rest;

import io.github.evolutionThroughCraft.account.models.AccountForm;
import io.github.evolutionThroughCraft.common.service.main.utils.ResourceUtility;
import org.springframework.stereotype.Component;

/**
 *
 * @author dwin
 */
@Component
public class CreateContract {
    
    public void validate(AccountForm form) {
        ResourceUtility.ensureResource(form);
        ResourceUtility.ensureResource(form.getUserName());
        ResourceUtility.ensureResource(form.getDisplayName());
        ResourceUtility.ensureResource(form.getCreateUser());
        ResourceUtility.ensureResource(form.getUpdateUser());
        ResourceUtility.ensureResource(form.getBalance());        
    }
}
