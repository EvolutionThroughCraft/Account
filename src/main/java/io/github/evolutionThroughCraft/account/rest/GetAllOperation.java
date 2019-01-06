/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.account.rest;

import io.github.evolutionThroughCraft.account.models.AccountEntity;
import io.github.evolutionThroughCraft.account.repo.AccountRepository;
import io.github.evolutionThroughCraft.common.arch.orchestrators.SimpleOperation;
import io.github.evolutionThroughCraft.common.service.main.models.ArgumentPlaceholder;
import java.util.List;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author dwin
 */
@Component
@Getter
public class GetAllOperation extends SimpleOperation <ArgumentPlaceholder, List<AccountEntity>> {
    
    @Autowired
    private AccountRepository accountRepo;
    
    @Override
    public List<AccountEntity> perform(ArgumentPlaceholder _unused) {
        return getAccountRepo().findAll();
    }
}
