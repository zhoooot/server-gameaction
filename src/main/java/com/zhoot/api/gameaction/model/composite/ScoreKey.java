package com.zhoot.api.gameaction.model.composite;

public class ScoreKey implements java.io.Serializable {
    private String gameid;
    private String playerid;

    public ScoreKey() {
    }

    public ScoreKey(String gameid, String playerid) {
        this.gameid = gameid;
        this.playerid = playerid;
    }

    public String getGameid() {
        return gameid;
    }

    public String getPlayerid() {
        return playerid;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid;
    }

    public void setPlayerid(String playerid) {
        this.playerid = playerid;
    }
}
