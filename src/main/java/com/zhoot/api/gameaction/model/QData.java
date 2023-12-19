package com.zhoot.api.gameaction.model;

public class QData implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer current_correct;

    public QData() {

    }

    public QData(Integer current_correct) {
        this.current_correct = current_correct;
    }

    public Integer getCurrent_correct() {
        return current_correct;
    }

    public void setCurrent_correct(Integer current_correct) {
        this.current_correct = current_correct;
    }

    @Override
    public String toString() {
        return "QData{" +
                "current_correct=" + current_correct +
                '}';
    }
}
