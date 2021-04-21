package com.study.repository;

import com.study.domain.EvaluateScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface EvaluateScoreRepository extends JpaRepository<EvaluateScore, Integer> {
}
