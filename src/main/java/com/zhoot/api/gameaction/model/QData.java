package com.zhoot.api.gameaction.model;

public class QData implements java.io.Serializable {

    private static final long serialVersionUID = 1L;

    private Integer current_correct;
    private Integer current_time;

    public QData() {

    }

    // public QData(Integer current_correct) {
    //     this.current_correct = current_correct;
    // }

    // public Integer getCurrent_correct() {
    //     return current_correct;
    // }

    // public void setCurrent_correct(Integer current_correct) {
    //     this.current_correct = current_correct;
    // }

    // @Override
    // public String toString() {
    //     return "QData{" +
    //             "current_correct=" + current_correct +
    //             '}';
    // }

    public QData(Integer current_correct, Integer current_time) {
        this.current_correct = current_correct;
        this.current_time = current_time;
    }

    public Integer getCurrent_correct() {
        return current_correct;
    }

    public void setCurrent_correct(Integer current_correct) {
        this.current_correct = current_correct;
    }

    public Integer getCurrent_time() {
        return current_time;
    }

    public void setCurrent_time(Integer current_time) {
        this.current_time = current_time;
    }

    @Override
    public String toString() {
        return "QData{" +
                "current_correct=" + current_correct +
                ", current_time=" + current_time +
                '}';
    }
}
