package com.zhoot.api.gameaction.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zhoot.api.gameaction.model.Score;
import com.zhoot.api.gameaction.model.composite.ScoreKey;

public interface ScoreRepo extends JpaRepository<Score, ScoreKey> {
}
