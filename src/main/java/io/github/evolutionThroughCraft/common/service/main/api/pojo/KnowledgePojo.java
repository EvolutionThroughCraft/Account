/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.common.service.main.api.pojo;

import io.github.evolutionThroughCraft.common.service.main.api.Knowledge;
import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author dwin
 */
@Getter @Setter
@NoArgsConstructor
public class KnowledgePojo implements Knowledge {
    
    private Long knowledgeId;
    private Long triviaId;
    private Long accountId;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;
}
