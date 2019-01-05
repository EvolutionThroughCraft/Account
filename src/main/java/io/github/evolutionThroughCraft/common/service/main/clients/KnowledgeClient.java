/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.common.service.main.clients;

import io.github.evolutionThroughCraft.common.service.main.api.Knowledge;
import io.github.evolutionThroughCraft.common.service.main.api.pojo.KnowledgePojo;
import io.github.evolutionThroughCraft.common.service.main.routes.KnowledgeRoutes;
import io.github.evolutionThroughCraft.common.service.main.utils.ResourceUtility;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jboss.logging.Logger;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author dwin
 */
public class KnowledgeClient implements KnowledgeRoutes {
    
    private static final Logger scribe = Logger.getLogger(KnowledgeClient.class);
    
    public Knowledge postKnowledge(Knowledge knowledge) {
        scribe.debug("route:"+POST_KNOWLEDGE_ROUTE+", know:"+knowledge);
        return new RestTemplate().postForObject(
                                    POST_KNOWLEDGE_ROUTE,
                                    knowledge,
                                    KnowledgePojo.class,
                                    new HashMap<>());
    }
    
    public List<Knowledge> getKnowledgeForAccount(Long accountId) {
        Map<String, Long> pathArgs = new HashMap<>();
        pathArgs.put(ACCOUNT_ID_VAR, accountId);
        scribe.debug("path:"+GET_KNOWLEDGE_ROUTE+", actId:"+accountId);
        KnowledgePojo[] results = new RestTemplate().getForObject(
                                                        GET_KNOWLEDGE_ROUTE,
                                                        KnowledgePojo[].class,
                                                        pathArgs);
        return ResourceUtility.asList(results);                
    }
}
