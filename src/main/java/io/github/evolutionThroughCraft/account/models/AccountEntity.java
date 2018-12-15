/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.account.models;

import io.github.evolutionThroughCraft.common.service.main.api.Account;
import io.github.evolutionThroughCraft.common.service.main.models.Stamps;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author dwin
 */
@Entity
@Table(name = "accounts")
@Getter @Setter
public class AccountEntity extends Stamps<String> implements Account {
    
    @Id @GeneratedValue(generator = "account_generator")
    @SequenceGenerator(
            name = "account_generator",
            sequenceName = "account_sequence",
            initialValue = 1000
    )
    private Long accountId;
    
    @NotBlank
    @Size(min = 3, max = 15)
    private String userName;
    
    private String displayName;

}
