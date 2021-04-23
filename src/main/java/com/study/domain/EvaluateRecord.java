package com.study.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Map;
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "T_EVALUATE_RECORD")
public class EvaluateRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "recordId")
    @GenericGenerator(name = "recordId", strategy = "com.study.ManulInsertGenerator")
    @Column(name = "id")//, columnDefinition = "自增主键"
    private int id;

    @Column(name = "big_category_id")
    private int bigCategoryId;

    @Column(name = "evaluate_time")
    private String evaluateTime;

    @Column(name = "username")
    private String username;

    @Transient
    private Map<Integer,EvaluateScore> smallCategoryScoreMap;

    public EvaluateRecord( @NotEmpty int bigCategoryId, String evaluateTime, String username) {
        this.bigCategoryId = bigCategoryId;
        this.evaluateTime = evaluateTime;
        this.username = username;
    }

    public EvaluateRecord() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBigCategoryId() {
        return bigCategoryId;
    }

    public void setBigCategoryId(int bigCategoryId) {
        this.bigCategoryId = bigCategoryId;
    }

    public String getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(String evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Map<Integer, EvaluateScore> getSmallCategoryScoreMap() {
        return smallCategoryScoreMap;
    }

    public void setSmallCategoryScoreMap(Map<Integer, EvaluateScore> smallCategoryScoreMap) {
        this.smallCategoryScoreMap = smallCategoryScoreMap;
    }
}
