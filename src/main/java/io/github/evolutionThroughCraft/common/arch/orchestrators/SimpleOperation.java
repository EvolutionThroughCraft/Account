/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.common.arch.orchestrators;

import io.github.evolutionThroughCraft.common.service.main.aop.LogTimeTaken;
import org.apache.log4j.Logger;


/**
 *
 * @author dwin
 */
public abstract class SimpleOperation<Arg, Rtn> implements Operation<Arg, Rtn> {
    
    private static final Logger scribe = Logger.getLogger(SimpleOperation.class);
    
    @Override
    public Rtn run(Arg arg) {
        scribe.debug("simple op start");
        Long time = System.currentTimeMillis();
        Rtn output =  perform(arg);
        scribe.debug("simple op run in:" + (System.currentTimeMillis() - time));
        return output;
    }
    
    public abstract Rtn perform(Arg arg);
}
