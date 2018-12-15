/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.common.service.main.api;

import java.util.Date;

/**
 *
 * @author dwin
 */
public interface Account {
    
    public Long getAccountId();
    public String getUserName();
    public String getDisplayName();
    public Date getCreateTime();
    public String getCreateUser();
    public Date getUpdateTime();
    public String getUpdateUser();
}
