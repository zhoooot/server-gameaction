package com.zhoot.api.gameaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.zhoot.api.gameaction.helper.SerializeHelper;
import com.zhoot.api.gameaction.model.*;

@Service
public class PowerService {
    @Autowired
    private RedisTemplate<String, Power> redisTemplate; //list; opForList

    public Power[] retrievePower(String gameid, String playerid) {
        SerializeHelper serializeHelper = new SerializeHelper(gameid, playerid);
        Power[] powers = redisTemplate.opsForList().range(serializeHelper.power(), 0, 3).toArray(new Power[4]);
        return powers;
    }

    public void addPower(String gameid, String playerid, Power power) {
        SerializeHelper serializeHelper = new SerializeHelper(gameid, playerid);
        redisTemplate.opsForList().rightPush(serializeHelper.power(), power);
    }

    public void removePower(String gameid, String playerid, Power power) {
        SerializeHelper serializeHelper = new SerializeHelper(gameid, playerid);
        // delete if power is in list
        redisTemplate.opsForList().remove(serializeHelper.power(), 1, power);
    }

    public void addMultiplePower(String gameid, String playerid, Power[] powers) {
        SerializeHelper serializeHelper = new SerializeHelper(gameid, playerid);
        redisTemplate.opsForList().rightPushAll(serializeHelper.power(), powers);
    }
}