/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.common.service.main.api.pojo;

import io.github.evolutionThroughCraft.common.service.main.api.Balance;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author dwin
 */
@Setter
@NoArgsConstructor
public class BalancePojo implements Balance {
    
    private Integer amount;
    
    @Override
    public Integer getAmount() {
        return amount;
    }
}
