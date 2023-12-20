package com.zhoot.api.gameaction.model;

import java.awt.Composite;
import java.util.ArrayList;
import java.util.List;

import com.zhoot.api.gameaction.model.composite.ScoreKey;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "score")
@IdClass(ScoreKey.class)
public class Score implements java.io.Serializable {

    @Id
    private String gameid;

    @Id
    private String playerid;

    @Column
    private int score;

    public Score() {
    }

    public Score(String gameid, String playerid, int score) {
        this.gameid = gameid;
        this.playerid = playerid;
        this.score = score;
    }

    public String getGameid() {
        return gameid;
    }

    public String getPlayerid() {
        return playerid;
    }

    public int getScore() {
        return score;
    }

    public void setGameid(String gameid) {
        this.gameid = gameid;
    }

    public void setPlayerid(String playerid) {
        this.playerid = playerid;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Score> createScores(String gameid2, String[] playerids, int[] scores) {
        List<Score> scoreList = new ArrayList<Score>();
        for (int i = 0; i < playerids.length; i++) {
            scoreList.add(new Score(gameid2, playerids[i], scores[i]));
        }
        return scoreList;
    }
}
