package com.zhoot.api.gameaction.model;

public class Affect implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private String otherid;

    private Integer powerid;

    public Affect() {

    }

    public Affect(String otherid, Integer powerid) {
        this.otherid = otherid;
        this.powerid = powerid;
    }

    public String getOtherid() {
        return otherid;
    }

    public void setOtherid(String otherid) {
        this.otherid = otherid;
    }

    public Integer getPowerid() {
        return powerid;
    }

    public void setPowerid(Integer powerid) {
        this.powerid = powerid;
    }

    @Override
    public String toString() {
        return "Affect{" +
                "otherid=" + otherid +
                ", powerid=" + powerid +
                '}';
    }
}
