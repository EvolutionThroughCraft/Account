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
public interface Operation<Arg, Rtn> {
    
    public Rtn run(Arg arg);
}
