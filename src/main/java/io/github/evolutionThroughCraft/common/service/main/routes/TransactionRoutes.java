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
public interface TransactionRoutes extends HttpsRoutes {

    ////  paths    
    public static final String TRANSACTION_ROOT = "/transactions";
    
    public static final String ACCOUNT_ID_VAR = "accountId";
    public static final String ACCOUNT_ID = "/{"+ ACCOUNT_ID_VAR + "}";
    public static final String BALANCE = "/balance";
    
    public static final String GET_TEST_PATH = TRANSACTION_ROOT;
    
    public static final String GET_TRANSACTIONS_PATH = TRANSACTION_ROOT + ACCOUNT_ID;
    public static final String GET_BALANCE_PATH = TRANSACTION_ROOT + ACCOUNT_ID + BALANCE;
    public static final String POST_TRANSACTIONS_PATH = TRANSACTION_ROOT;
    public static final String DELETE_TRANSACTIONS_PATH = TRANSACTION_ROOT + ACCOUNT_ID;

    ////  routes
    public static final String TRANSACTION_PORT = ":8081";
    public static final String TRANSACTION_ROOT_ROUTE = WEB_ROOT_ROUTE + TRANSACTION_PORT;
    
    public static final String GET_TRANSACTIONS_ROUTE = TRANSACTION_ROOT_ROUTE+GET_TRANSACTIONS_PATH;
    public static final String GET_BALANCE_ROUTE = TRANSACTION_ROOT_ROUTE+GET_BALANCE_PATH;
    public static final String POST_TRANSACTIONS_ROUTE = TRANSACTION_ROOT_ROUTE+POST_TRANSACTIONS_PATH;
    public static final String DELETE_TRANSACTIONS_ROUTE = TRANSACTION_ROOT_ROUTE+DELETE_TRANSACTIONS_PATH;
}
