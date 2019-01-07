/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.common.service.main.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 *
 * @author dwin
 */
@Aspect
@Component
public class PerformanceLogger {
    
    private static final Logger scribe = Logger.getLogger(PerformanceLogger.class);
    
    @Around("execution(* io.github.evolutionThroughCraft.account.rest..*(..)) && @annotation(io.github.evolutionThroughCraft.common.service.main.aop.LogTimeTaken)")
    public void logPerformance(ProceedingJoinPoint point) throws Throwable {
        scribe.warn(point.getSignature().getName());
        long time = System.currentTimeMillis();

        point.proceed();
        
        
        long diff = System.currentTimeMillis() - time;
        scribe.warn("Took " + diff);
        
        
    }
}
