/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.account.rest;

import io.github.evolutionThroughCraft.account.models.AccountForm;
import io.github.evolutionThroughCraft.account.repo.AccountRepository;
import io.github.evolutionThroughCraft.common.service.main.utils.ResourceUtility;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dwin
 */
@Component("accountUpdate")
@Getter
public class UpdateContract extends CreateContract {
    
    @Autowired
    private AccountRepository accountRepo;
        
    @Override
    public void validate(AccountForm form) {
        // create validations
        super.validate(form);
        
        // update validations
        ResourceUtility.ensureResource(form.getAccountId(), "Account id Missing");
        ResourceUtility.ensureResource(getAccountRepo().getOne(form.getAccountId()), "Existing Account Missing");        
    }
}
