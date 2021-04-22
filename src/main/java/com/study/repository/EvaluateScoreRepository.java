package com.study.repository;

import com.study.domain.EvaluateScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface EvaluateScoreRepository extends JpaRepository<EvaluateScore, Integer> {
    @Query("select e from EvaluateScore e where e.evaluateId =  :evaluateId")
    List<EvaluateScore> queryEvaluateScoreByEvaluateId(@Param("evaluateId")int evaluateId);

}
