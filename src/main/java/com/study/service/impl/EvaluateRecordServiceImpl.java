package com.study.service.impl;

import com.study.domain.EvaluateRecord;
import com.study.domain.EvaluateScore;
import com.study.domain.SmallCategory;
import com.study.repository.BigCategoryRepository;
import com.study.repository.EvaluateRecordRepository;
import com.study.repository.EvaluateScoreRepository;
import com.study.repository.SmallCategoryRepository;
import com.study.service.IEvaluatePaperService;
import com.study.service.IEvaluateRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EvaluateRecordServiceImpl implements IEvaluateRecordService {
    @Autowired
    private EvaluateRecordRepository evaluateRecordRepository;

    @Autowired
    private EvaluateScoreRepository evaluateScoreRepository;

    @Autowired
    private BigCategoryRepository bigCategoryRepository;

    @Autowired
    private SmallCategoryRepository smallCategoryRepository;

    @Override
    public List<EvaluateRecord> queryAll() {
        List<EvaluateRecord> recordList = evaluateRecordRepository.findAll();
        for(EvaluateRecord evaluateRecord : recordList){
            List<SmallCategory> smallCategories =
                    smallCategoryRepository.queryByBigCategory(evaluateRecord.getBigCategoryId());
            List<EvaluateScore> evaluateScores =
                    evaluateScoreRepository.queryEvaluateScoreByEvaluateId(evaluateRecord.getId());
            Map<Integer, EvaluateScore> evaluateScoreMap = evaluateScores.stream().collect(Collectors.toMap(
                    evaluateScore -> evaluateScore.getSmallCategoryId(),
                    evaluateScore -> evaluateScore,
                    (evaluateScore0, evaluateScore1) -> evaluateScore0
            ));
            Map<Integer,EvaluateScore> evaluateScoreResultMap = new HashMap<>();
            evaluateRecord.setSmallCategoryScoreMap(evaluateScoreResultMap);
            for(SmallCategory smallCategory : smallCategories){
                evaluateScoreResultMap.put(smallCategory.getSmallCategoryId(),
                        evaluateScoreMap.getOrDefault(smallCategory.getSmallCategoryId(),
                                new EvaluateScore(evaluateRecord.getId(),smallCategory.getSmallCategoryId(),0))
                        );
            }
        }
        return recordList;
    }

    @Override
    public EvaluateRecord query(String evaluateId) {
        EvaluateRecord evaluateRecord =  evaluateRecordRepository.findById(Integer.valueOf(evaluateId)).get();
        if(evaluateRecord!=null){
            List<SmallCategory> smallCategories =
                    smallCategoryRepository.queryByBigCategory(evaluateRecord.getBigCategoryId());
            List<EvaluateScore> evaluateScores =
                    evaluateScoreRepository.queryEvaluateScoreByEvaluateId(evaluateRecord.getId());
            Map<Integer, EvaluateScore> evaluateScoreMap = evaluateScores.stream().collect(Collectors.toMap(
                    evaluateScore -> evaluateScore.getSmallCategoryId(),
                    evaluateScore -> evaluateScore,
                    (evaluateScore0, evaluateScore1) -> evaluateScore0
            ));
            Map<Integer,EvaluateScore> evaluateScoreResultMap = new HashMap<>();
            evaluateRecord.setSmallCategoryScoreMap(evaluateScoreResultMap);
            for(SmallCategory smallCategory : smallCategories){
                evaluateScoreResultMap.put(smallCategory.getSmallCategoryId(),
                        evaluateScoreMap.getOrDefault(smallCategory.getSmallCategoryId(),
                                new EvaluateScore(evaluateRecord.getId(),smallCategory.getSmallCategoryId(),0))
                );
            }
        }
        return evaluateRecord;
    }
}
