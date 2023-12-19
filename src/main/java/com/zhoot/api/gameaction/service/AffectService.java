package com.zhoot.api.gameaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.zhoot.api.gameaction.helper.SerializeHelper;
import com.zhoot.api.gameaction.model.*;

@Service
public class AffectService {
    @Autowired
    private RedisTemplate<String, Affect> redisTemplate; //list; opForList

    public Affect retrieveAffect(String gameid, String playerid) {
        SerializeHelper serializeHelper = new SerializeHelper(gameid, playerid);
        Affect affect = redisTemplate.opsForValue().get(serializeHelper.affected());
        return affect;
    }

    public void addAffect(String gameid, String playerid, Affect affect) {
        SerializeHelper serializeHelper = new SerializeHelper(gameid, playerid);
        redisTemplate.opsForValue().set(serializeHelper.affected(), affect);
    }

    public void removeAffect(String gameid, String playerid) {
        SerializeHelper serializeHelper = new SerializeHelper(gameid, playerid);
        redisTemplate.delete(serializeHelper.affected());
    }

    public void updateAffect(String gameid, String playerid, Affect affect) {
        SerializeHelper serializeHelper = new SerializeHelper(gameid, playerid);
        redisTemplate.opsForValue().set(serializeHelper.affected(), affect);
    }
}
