package com.zhoot.api.gameaction.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;

import com.zhoot.api.gameaction.model.Answer;
import com.zhoot.api.gameaction.model.Score;
import com.zhoot.api.gameaction.model.composite.ScoreKey;
import com.zhoot.api.gameaction.repo.ScoreRepo;

import jakarta.transaction.Transactional;

public class ScoreService {
    @Autowired
    private ScoreRepo scoreRepo;

    @Autowired
    private AnswerService answerService;

    @Autowired
    private QDataService qDataService;

    public int[] calculatePointReward(String gameid) {
        Answer[] answers = answerService.retrieveAllAnswer(gameid);
        Arrays.sort(answers);
        int correct_answer = qDataService.retrieveQData(gameid).getCurrent_correct();
        int max_time = qDataService.retrieveQData(gameid).getCurrent_time();
        int[] scores = new int[answers.length];
        for (int i = 0; i < answers.length; i++) {
            if (answers[i].getAid() == correct_answer) {
                scores[i] = (int)(1000 * (max_time - answers[i].getTime()) / max_time);
            } else {
                scores[i] = 0;
            }
        }
        return scores;
    }

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