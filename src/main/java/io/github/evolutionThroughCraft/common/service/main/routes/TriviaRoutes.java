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
public interface TriviaRoutes extends HttpsRoutes {
    
        //// vars
    public static String TRIVIA_ID_VAR = "trivId";
    public static String TRIVIA_ID = "/{"+TRIVIA_ID_VAR+"}";
    public static String QUESTION_VAR = "ques";
    
    //// paths
    public static final String TRIVIA_ROOT = "/trivia";
    public static final String POST_TRIVIA_PATH = TRIVIA_ROOT;
    public static final String PUT_TRIVIA_PATH = TRIVIA_ROOT+TRIVIA_ID;
    public static final String GET_TRIVIA_PATH = TRIVIA_ROOT;

    //// routes
    public static final String TRIVIA_PORT = ":8084";
    public static final String TRIVIA_ROOT_ROUTE = WEB_ROOT_ROUTE + TRIVIA_PORT;
    
    public static final String POST_TRIVIA_ROUTE = TRIVIA_ROOT_ROUTE + POST_TRIVIA_PATH;
    public static final String PUT_TRIVIA_ROUTE = TRIVIA_ROOT_ROUTE+PUT_TRIVIA_PATH;
    public static final String GET_TRIVIA_ROUTE = TRIVIA_ROOT_ROUTE+GET_TRIVIA_PATH;
}
