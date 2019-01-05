/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.common.arch.orchestrators;

/**
 *
 * @author dwin
 */
public abstract class SimpleOperation<Arg, Rtn> implements Operation<Arg, Rtn> {
    
    @Override
    public Rtn run(Arg arg) {
        return perform(arg);
    }
    
    public abstract Rtn perform(Arg arg);
}
