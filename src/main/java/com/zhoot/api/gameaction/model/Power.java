package com.zhoot.api.gameaction.model;

public class Power implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer pid;

    private String affectedPlayer;

    Power() {
    }

    public Power(Integer pid) {
        this.pid = pid;
        this.affectedPlayer = "";
    }

    public Power(Integer pid, String affectedPlayer) {
        this.pid = pid;
        this.affectedPlayer = affectedPlayer;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer id) {
        this.pid = id;
    }

    public String getAffectedPlayer() {
        return affectedPlayer;
    }

    public void setAffectedPlayer(String affectedPlayer) {
        this.affectedPlayer = affectedPlayer;
    }

    @Override
    public String toString() {
        return "Power{" +
                "pid=" + pid +
                '}';
    }
}
