package com.devsuperior.dsmove.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devsuperior.dsmove.entities.Score;
import com.devsuperior.dsmove.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
