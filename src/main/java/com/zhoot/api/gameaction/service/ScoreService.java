package com.zhoot.api.gameaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import com.zhoot.api.gameaction.model.Score;
import com.zhoot.api.gameaction.model.composite.ScoreKey;
import com.zhoot.api.gameaction.repo.ScoreRepo;

import jakarta.transaction.Transactional;

public class ScoreService {
    @Autowired
    private ScoreRepo scoreRepo;

    @Transactional
    public int retrieveScore(String gameid, String playerid) {
        ScoreKey scoreKey = new ScoreKey(gameid, playerid);
        int score = scoreRepo.findById(scoreKey).get().getScore();
        return score;
    }

    @Transactional
    public void addScore(String gameid, String playerid, int score) {
        int currentScore = retrieveScore(gameid, playerid);
        ScoreKey scoreKey = new ScoreKey(gameid, playerid);
        scoreRepo.findById(scoreKey).get().setScore(currentScore + score);
    }

    @Transactional
    public void addScoresToAGame(String gameid, String[] playerids, int[] scores) {
        scoreRepo.saveAll(Score.createScores(gameid, playerids, scores));
    }

    @Transactional
    public Score[] retrieveAllScore(String gameid) {
        Score[] scores = scoreRepo.findAll().stream().filter(score -> score.getGameid().equals(gameid))
                .toArray(Score[]::new);
        return scores;
    }

    @Transactional
    public void removeScore(String gameid, String playerid) {
        ScoreKey scoreKey = new ScoreKey(gameid, playerid);
        scoreRepo.deleteById(scoreKey);
    }

    @Transactional
    @Query("DELETE FROM Score WHERE gameid = ?1")
    public void removeAllScore(String gameid) {
    }
}