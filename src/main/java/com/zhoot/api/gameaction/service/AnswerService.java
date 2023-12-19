package com.zhoot.api.gameaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.zhoot.api.gameaction.model.*;

@Service
public class AnswerService {
    @Autowired
    private RedisTemplate<String, Answer> redisTemplate; //list; opForList

    public Answer[] retrieveAllAnswer(String gameid) {
        List<Answer> answers = redisTemplate.opsForList().range(gameid, 0, -1);
        if (answers == null) {
            return null;
        }
        return answers.toArray(new Answer[answers.size()]);
    }

    public void addAnswer(String gameid, Answer answer) {
        redisTemplate.opsForList().rightPush(gameid, answer);
    }

    public void removeAnswer(String gameid, Answer answer) {
        // delete if answer is in list
        redisTemplate.opsForList().remove(gameid, 1, answer);
    }
}
