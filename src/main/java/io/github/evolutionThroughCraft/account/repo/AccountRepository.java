/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.account.repo;

import io.github.evolutionThroughCraft.account.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dwin
 */
public interface AccountRepository extends JpaRepository<Account, Long> {
    
}
