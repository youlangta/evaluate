package com.study.repository;

import com.study.domain.EvaluateRecord;
import com.study.domain.EvaluateScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface EvaluateRecordRepository extends JpaRepository<EvaluateRecord, Integer> {
}
