/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.evolutionThroughCraft.common.service.main.api.pojo;

import java.util.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import io.github.evolutionThroughCraft.common.service.main.api.Trivia;

/**
 *
 * @author dwin
 */
@Getter @Setter
@NoArgsConstructor
public class TriviaPojo implements Trivia {

    private Long triviaId;
    private String question;
    private String answer;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;
    

}
