package com.study.service.impl;

import com.study.domain.*;
import com.study.repository.*;
import com.study.service.IEvaluatePaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class EvaluatePaperServiceImpl implements IEvaluatePaperService {
    @Value("${evaluate.smallCateType.num:1}")
    private int smallCateTypeEvaluateNum;//每个小类测试试题的个数 默认为1

    @Autowired
    private BigCategoryRepository bigCategoryRepository;

    @Autowired
    private SmallCategoryRepository smallCategoryRepository;

    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private EvaluateRecordRepository evaluateRecordRepository;

    @Autowired
    private EvaluateScoreRepository evaluateScoreRepository;

    @Override
    public EvaluatePaper createNew(String bigCategoryId) {
        Random random = new Random();
        EvaluatePaper evaluatePaper = new EvaluatePaper();
        List<Subject> paperSubjects = new LinkedList<>();
        evaluatePaper.setSubjects(paperSubjects);
        evaluatePaper.setBigCategoryId(bigCategoryId);
        BigCategory bigCategory = bigCategoryRepository.findById(bigCategoryId).get();
        bigCategory.setSmallCategories(smallCategoryRepository.queryByBigCategory(bigCategory.getBigCategoryId()));
        List<Subject> subjects = subjectRepository.queryByBigCateroy(bigCategoryId);
        Map<String, List<Subject>> smallSubjectMap = subjects.stream()
                .collect(Collectors.toMap(
                        subject -> subject.getSmallCategoryId(),
                        subject -> {
                            List<Subject> result = new ArrayList<>();
                            result.add(subject);
                            return result;
                        },
                        (result1, result2) -> {
                            result1.addAll(result2);
                            return result1;
                        }
                ));
        List<SmallCategory> smallCategories = bigCategory.getSmallCategories();
        evaluatePaper.setSmallCategorys(smallCategories);


        for(SmallCategory smallCategory : smallCategories){
            String smallCategoryId = smallCategory.getSmallCategoryId();
            List<Subject>  smallSubjects =   smallSubjectMap.getOrDefault(smallCategoryId,new ArrayList<>());
            for(int i =0;i<smallCateTypeEvaluateNum;i++){
                if(smallCategories.isEmpty()){
                    break;
                }
                int subjectIndex =  random.nextInt(smallSubjects.size());
                Subject subject =  smallSubjects.remove(subjectIndex);
                paperSubjects.add(subject);
            }
        }
        return evaluatePaper;
    }

    @Override
    public EvaluateRecord insert(EvaluatePaper evaluatePaper) {
        EvaluateRecord evaluateRecord = new EvaluateRecord(evaluatePaper.getBigCategoryId()
                ,evaluatePaper.getEvaluateTime(),evaluatePaper.getUsername());
        evaluateRecordRepository.saveAndFlush(evaluateRecord);
        List<Subject> subjects = evaluatePaper.getSubjects();
        Map<String, List<Subject>> smallSubjectMap = subjects.stream()
                .collect(Collectors.toMap(
                        subject -> subject.getSmallCategoryId(),
                        subject -> {
                            List<Subject> result = new ArrayList<>();
                            result.add(subject);
                            return result;
                        },
                        (result1, result2) -> {
                            result1.addAll(result2);
                            return result1;
                        }
                ));
        List<SmallCategory> smallCategorys = evaluatePaper.getSmallCategorys();
        Map<String,EvaluateScore> smallCategoryScoreMap = new HashMap<>();
        evaluateRecord.setSmallCategoryScoreMap(smallCategoryScoreMap);
        for(SmallCategory smallCategory : smallCategorys){
            String smallCategoryId = smallCategory.getSmallCategoryId();
            List<Subject>  smallSubjects =   smallSubjectMap.getOrDefault(smallCategoryId,new ArrayList<>());
            EvaluateScore evaluateScore = new EvaluateScore();
            evaluateScore.setEvaluateId(evaluateRecord.getId());
            evaluateScore.setSmallCategoryId(smallCategoryId);
            smallCategoryScoreMap.put(smallCategoryId,evaluateScore);
            if(smallSubjects.isEmpty()){
                evaluateScore.setScore(0);
            }else{
                //100
                int totalWeight = smallSubjects.stream().mapToInt(subject -> subject.getSubjectWeight()).sum();
                //BigDecimal singelSubjectScore = new BigDecimal(100).divide(new BigDecimal(smallSubjects.size()),1, RoundingMode.DOWN);
                BigDecimal resultScore = new BigDecimal(0);
                for(Subject subject :smallSubjects ){
                    int evaluateAnswer = subject.getEvaluateAnswer();
                    int subjectAnswer = subject.getSubjectAnswer();
                    if(evaluateAnswer == subjectAnswer){
                        resultScore = resultScore.add(new BigDecimal(subject.getSubjectWeight())
                                .divide(new BigDecimal(totalWeight),1,RoundingMode.DOWN).multiply(new BigDecimal(100)));
                    }
                }
                evaluateScore.setScore(resultScore.intValue());
            }
        }
        evaluateScoreRepository.saveAll(smallCategoryScoreMap.values());
        return evaluateRecord;
    }
}
