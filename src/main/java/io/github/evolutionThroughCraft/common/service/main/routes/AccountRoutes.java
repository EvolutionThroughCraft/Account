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
public interface AccountRoutes extends HttpsRoutes {
    
    //// paths
    public static final String ACCOUNT_ROOT = "/accounts";

    public static final String ACCOUNT_ID_VAR = "actId";
    public static final String ACCOUNT_ID = "/{"+ACCOUNT_ID_VAR+"}";

    public static final String GET_ALL_ACCOUNT_PATH = ACCOUNT_ROOT;
    public static final String GET_ACCOUNT_PATH = ACCOUNT_ROOT+ACCOUNT_ID;
    public static final String POST_ACCOUNT_PATH = ACCOUNT_ROOT;
    public static final String PUT_ACCOUNT_PATH = ACCOUNT_ROOT+ACCOUNT_ID;
    public static final String DELETE_ACCOUNT_PATH = ACCOUNT_ROOT+ACCOUNT_ID;    
    
    ////  routes
    public static final String ACCOUNT_PORT = ":8082";
    public static final String ACCOUNT_ROOT_ROUTE = WEB_ROOT_ROUTE + ACCOUNT_PORT;

    public static final String GET_ALL_ACCOUNTS_ROUTE = ACCOUNT_ROOT_ROUTE+GET_ALL_ACCOUNT_PATH;    
    public static final String GET_ACCOUNT_ROUTE = ACCOUNT_ROOT_ROUTE+GET_ACCOUNT_PATH;
    public static final String POST_ACCOUNT_ROUTE = ACCOUNT_ROOT_ROUTE+POST_ACCOUNT_PATH;
    public static final String PUT_ACCOUNT_ROUTE = ACCOUNT_ROOT_ROUTE+PUT_ACCOUNT_PATH;
    public static final String DELETE_ACCOUNT_ROUTE = ACCOUNT_ROOT_ROUTE+DELETE_ACCOUNT_PATH;
}

