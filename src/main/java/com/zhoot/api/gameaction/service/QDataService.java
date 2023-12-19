package com.zhoot.api.gameaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.zhoot.api.gameaction.model.QData;

@Service
public class QDataService {
    @Autowired
    private RedisTemplate<String, QData> redisTemplate; 

    public QData retrieveQData(String gameid) {
        QData qdata = redisTemplate.opsForValue().get(gameid);
        return qdata;
    }

    public QData addQData(String gameid, QData qdata) {
        redisTemplate.opsForValue().set(gameid, qdata);
        return qdata;
    }

    public void removeQData(String gameid) {
        redisTemplate.delete(gameid);
    }

    public void updateQData(String gameid, QData qdata) {
        redisTemplate.opsForValue().set(gameid, qdata);
    }
}
