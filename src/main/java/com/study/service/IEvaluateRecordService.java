package com.study.service;

import com.study.domain.EvaluateRecord;
import com.study.domain.EvaluateScore;

import java.util.List;

public interface IEvaluateRecordService {

    List<EvaluateRecord> queryAll();

    EvaluateRecord query(String evaluateId);

}
