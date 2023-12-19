package com.zhoot.api.gameaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhoot.api.gameaction.dto.PowerDto;
import com.zhoot.api.gameaction.model.Affect;
import com.zhoot.api.gameaction.model.Power;
import com.zhoot.api.gameaction.service.AffectService;
import com.zhoot.api.gameaction.service.PowerService;

@RestController
@RequestMapping("/power")
public class PowerController {

    @Autowired
    private PowerService powerService;

    @Autowired
    private AffectService affectService;

    @GetMapping("/{gameid}/{playerid}")
    public Power[] retrievePower(@PathVariable String gameid, @PathVariable String playerid) {
        return powerService.retrievePower(gameid, playerid);
    }

    @PostMapping("")
    public Power addPower(@RequestBody PowerDto powerDto) {
        Power power = new Power(powerDto.getPowerid(), powerDto.getAffectedPlayer());
        powerService.addPower(powerDto.getGameid(), powerDto.getPlayerid(), power);
        affectService.addAffect(powerDto.getGameid(), powerDto.getAffectedPlayer(), new Affect(powerDto.getPlayerid(), powerDto.getPowerid()));
        return power;
    }
    
    @DeleteMapping("/remove")
    public void removePower(@RequestBody PowerDto powerDto) {
        Power power = new Power(powerDto.getPowerid(), powerDto.getAffectedPlayer());
        powerService.removePower(powerDto.getGameid(), powerDto.getPlayerid(), power);
    }

    @GetMapping("/affect/{gameid}/{playerid}")
    public Affect retrieveAffect(@PathVariable String gameid, @PathVariable String playerid) {
        return affectService.retrieveAffect(gameid, playerid);
    }

    @DeleteMapping("/affect/{gameid}/{playerid}")
    public void removeAffect(@PathVariable String gameid, @PathVariable String playerid) {
        affectService.removeAffect(gameid, playerid);
    }
}