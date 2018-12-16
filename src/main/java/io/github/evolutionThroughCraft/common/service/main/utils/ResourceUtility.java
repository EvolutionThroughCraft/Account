/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.common.service.main.utils;

import io.github.evolutionThroughCraft.common.service.main.models.BadRequestException;
import io.github.evolutionThroughCraft.common.service.main.models.ResourceNotFoundException;

/**
 *
 * @author dwin
 */
public class ResourceUtility {
    
    public static <Resource> Resource ensureResource(Resource resource) {
        if(null == resource) {
            throw new ResourceNotFoundException();
        }
        return resource;
    }
    
    public static <T> void ensureIdsEqual(T firstId, T secondId) {
        if(null == firstId || null == secondId || !firstId.equals(secondId)) {
            throw new BadRequestException();
        }
    }
}
