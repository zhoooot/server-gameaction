package com.zhoot.api.gameaction.model;

public class Answer implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String playerid;
    private Integer aid;
    private Float time;

    public Answer() {
    }

    public Answer(Integer aid) {
        this.aid = aid;
    }

    public Answer(Integer aid, Float time) {
        this.aid = aid;
        this.time = time;
    }

    public Answer(String playerid, Integer aid, Float time) {
        this.playerid = playerid;
        this.aid = aid;
        this.time = time;
    }

    public String getPlayerid() {
        return playerid;
    }

    public void setPlayerid(String id) {
        this.playerid = id;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer id) {
        this.aid = id;
    }

    public Float getTime() {
        return time;
    }

    public void setTime(Float time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "playerid=" + playerid +
                ", aid=" + aid +
                ", time=" + time +
                '}';
    }
}
