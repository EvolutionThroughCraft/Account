/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.common.service.main.clients;

import io.github.evolutionThroughCraft.common.service.main.api.Account;
import io.github.evolutionThroughCraft.common.service.main.api.pojo.AccountPojo;
import io.github.evolutionThroughCraft.common.service.main.routes.AccountRoutes;
import io.github.evolutionThroughCraft.common.service.main.utils.ResourceUtility;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author dwin
 */
public class AccountClient implements AccountRoutes {
    
    private static final Logger scribe = Logger.getLogger(AccountClient.class);
    
    public Account getAccount(Long id) {
        Map<String, Long> pathArgs = new HashMap<>();
        pathArgs.put(ACCOUNT_ID_VAR, id);
        scribe.debug("route:"+GET_ACCOUNT_ROUTE+", id:"+id);
        AccountPojo[] maybe = new RestTemplate().getForObject(
                                    GET_ACCOUNT_ROUTE,// req path
                                    AccountPojo[].class, // return obj
                                    pathArgs); // args
        
        return ResourceUtility.optionalGet(maybe);
    }
}
