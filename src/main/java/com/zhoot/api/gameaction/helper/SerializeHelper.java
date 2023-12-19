package com.zhoot.api.gameaction.helper;

public class SerializeHelper {
    private String gameid;
    private String playerid;

    public SerializeHelper(String gameid, String playerid) {
        this.gameid = gameid;
        this.playerid = playerid;
    }

    public String getGameid() {
        return gameid;
    }

    public String getPlayerid() {
        return playerid;
    }

    @Override
    public String toString() {
        return "SerializeHelper{" +
                "gameid='" + gameid + '\'' +
                ", playerid='" + playerid + '\'' +
                '}';
    }

    public String power() {
        return gameid + ":" + playerid + ":power";
    }

    public String answer() {
        return gameid + ":" + playerid + ":answer";
    }

    public String affected() {
        return gameid + ":" + playerid + ":affected";
    }
}   
