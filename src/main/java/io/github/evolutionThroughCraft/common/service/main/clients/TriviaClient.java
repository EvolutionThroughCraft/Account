/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.common.service.main.clients;

import io.github.evolutionThroughCraft.common.service.main.api.Trivia;
import io.github.evolutionThroughCraft.common.service.main.api.pojo.TriviaPojo;
import io.github.evolutionThroughCraft.common.service.main.routes.TriviaRoutes;
import io.github.evolutionThroughCraft.common.service.main.utils.ResourceUtility;
import java.util.HashMap;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author dwin
 */
public class TriviaClient implements TriviaRoutes {
    
    private static final Logger scribe = Logger.getLogger(TriviaClient.class);
    
    public Trivia postTrivia(Trivia trivia) {
        scribe.debug("route:"+POST_TRIVIA_ROUTE+", trivia:"+trivia);
        return new RestTemplate().postForObject(
                                    POST_TRIVIA_ROUTE, // request path
                                    trivia, // model to save
                                    TriviaPojo.class, // return class
                                    new HashMap<>()); // path args
    }
    
    public Trivia putTrivia(Trivia trivia) {
        scribe.debug("route:"+PUT_TRIVIA_ROUTE+", trivia:"+trivia);
        return new RestTemplate().patchForObject(
                                    PUT_TRIVIA_ROUTE, // request path
                                    trivia, // model to save
                                    TriviaPojo.class, // return class
                                    new HashMap<>()); // path args        
    }
    
    public List<Trivia> getMatchingTrivia(Trivia trivia) {
        scribe.debug("route:"+GET_TRIVIA_ROUTE+", trivia:"+trivia);
        TriviaPojo[] results = new RestTemplate().getForObject(
                                                    GET_TRIVIA_ROUTE, 
                                                    TriviaPojo[].class,
                                                    new HashMap<>());
        return ResourceUtility.asList(results);
    }
}
