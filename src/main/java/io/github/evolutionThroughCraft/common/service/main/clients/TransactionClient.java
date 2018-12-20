/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.common.service.main.clients;

import io.github.evolutionThroughCraft.common.service.main.api.Balance;
import io.github.evolutionThroughCraft.common.service.main.api.Transaction;
import io.github.evolutionThroughCraft.common.service.main.api.pojo.BalancePojo;
import io.github.evolutionThroughCraft.common.service.main.api.pojo.TransactionPojo;
import io.github.evolutionThroughCraft.common.service.main.routes.TransactionRoutes;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author dwin
 */
public class TransactionClient implements TransactionRoutes {
    
    private static final Logger scribe = Logger.getLogger(TransactionClient.class);
    
    public Transaction postTransaction(Transaction transaction) {
        scribe.debug("route:"+POST_TRANSACTIONS_ROUTE+", trans:"+transaction);
        return new RestTemplate().postForObject(
                                    POST_TRANSACTIONS_ROUTE, // request path
                                    transaction, // model to save
                                    TransactionPojo.class, // return class
                                    new HashMap<>()); // path args
    }
    
    public Balance getAccountBalance(Long accountId) {
        Map<String, Long> pathArgs = new HashMap<>();
        pathArgs.put(ACCOUNT_ID_VAR, accountId);
        scribe.debug("path:"+GET_TRANSACTIONS_ROUTE+", act:"+accountId);
        BalancePojo[] maybe = new RestTemplate().getForObject(
                                                    GET_TRANSACTIONS_ROUTE, // request path
                                                    BalancePojo[].class, // return class
                                                    pathArgs); // path args
        
        if(0 == maybe.length) {
            return null;
        } else {
            return maybe[0];
        }
//        return maybe;
        
    }
}
