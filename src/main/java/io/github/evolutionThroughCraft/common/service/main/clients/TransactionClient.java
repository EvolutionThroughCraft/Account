/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.common.service.main.clients;

import io.github.evolutionThroughCraft.common.service.main.api.Transaction;
import io.github.evolutionThroughCraft.common.service.main.api.pojo.TransactionPojo;
import io.github.evolutionThroughCraft.common.service.main.routes.TransactionRoutes;
import java.util.HashMap;
import java.util.Map;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author dwin
 */
public class TransactionClient implements TransactionRoutes {
    
    public Transaction postTransaction(Transaction transaction) {
        return new RestTemplate().postForObject(
                                    POST_TRANSACTIONS_PATH, // request path
                                    transaction, // model to save
                                    TransactionPojo.class, // return class
                                    new HashMap<>()); // path args
    }
    
    public Long getAccountBalance(Long accountId) {
        Map<String, Long> pathArgs = new HashMap<>();
        pathArgs.put(ACCOUNT_ID_VAR, accountId);
        return new RestTemplate().getForObject(
                                    GET_BALANCE_PATH, // request path
                                    Long.class, // return class
                                    pathArgs); // path args
    }
}
