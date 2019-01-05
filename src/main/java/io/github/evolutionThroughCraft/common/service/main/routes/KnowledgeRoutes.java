/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.common.service.main.routes;

/**
 *
 * @author dwin
 */
public interface KnowledgeRoutes extends HttpsRoutes {

    //// vars
    public static String ACCOUNT_ID_VAR = "actId";
    
    //// paths
    public static final String KNOWLEDGE_ROOT = "/knows";
    public static final String POST_KNOWLEDGE_PATH = KNOWLEDGE_ROOT;
    public static final String GET_KNOWLEDGE_PATH = KNOWLEDGE_ROOT;

    //// routes
    public static final String KNOWLEDGE_PORT = ":8083";
    public static final String KNOWLEDGE_ROOT_ROUTE = WEB_ROOT_ROUTE + KNOWLEDGE_PORT;
    
    public static final String POST_KNOWLEDGE_ROUTE = KNOWLEDGE_ROOT_ROUTE + POST_KNOWLEDGE_PATH;
    public static final String GET_KNOWLEDGE_ROUTE = KNOWLEDGE_ROOT_ROUTE+GET_KNOWLEDGE_PATH;
}
