package com.calil.dsmovie.repositories;

import com.calil.dsmovie.entities.Score;
import com.calil.dsmovie.entities.ScorePk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreRepository extends JpaRepository<Score, ScorePk> {
}
