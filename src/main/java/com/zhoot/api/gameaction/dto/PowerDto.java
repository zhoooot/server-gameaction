package com.zhoot.api.gameaction.dto;

public class PowerDto {
    private String gameid;
    private String playerid;
    private Integer powerid;
    private String affectedPlayer;

    public PowerDto() {
    }

    public PowerDto(String gameid, String playerid) {
        this.gameid = gameid;
        this.playerid = playerid;
        this.powerid = 0;
        this.affectedPlayer = "";
    }

    public PowerDto(String gameid, String playerid, Integer powerid, String affectedPlayer) {
        this.gameid = gameid;
        this.playerid = playerid;
        this.powerid = powerid;
        this.affectedPlayer = affectedPlayer;
    }

    public PowerDto(String gameid, String playerid, Integer powerid) {
        this.gameid = gameid;
        this.playerid = playerid;
        this.powerid = powerid;
        this.affectedPlayer = "";
    }

    public String getGameid() {
        return this.gameid;
    }

    public String getPlayerid() {
        return this.playerid;
    }

    public Integer getPowerid() {
        return this.powerid;
    }

    @Override
    public String toString() {
        return "PowerDto{" +
                "gameid='" + gameid + '\'' +
                ", playerid='" + playerid + '\'' +
                ", powerid=" + powerid +
                '}';
    }

    public void setGameid(String gameid) {
        this.gameid = gameid;
    }

    public void setPlayerid(String playerid) {
        this.playerid = playerid;
    }

    public void setPowerid(Integer powerid) {
        this.powerid = powerid;
    }

    public String getAffectedPlayer() {
        return affectedPlayer;
    }

    public void setAffectedPlayer(String affectedPlayer) {
        this.affectedPlayer = affectedPlayer;
    }
}
