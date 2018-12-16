/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.common.service.main.clients;

import io.github.evolutionThroughCraft.common.service.main.api.Transaction;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author dwin
 */
public class TransactionClient {
    
    public Transaction post(Transaction transaction) {
        RestTemplate restCall = new RestTemplate();
        return null;
    }
}
