package com.study.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Map;

@Entity
@Table(name = "T_EVALUATE_RECORD")
public class EvaluateRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")//, columnDefinition = "自增主键"
    private int id;

    @Column(name = "big_category_id")
    @NotEmpty
    private String bigCategoryId;

    @Column(name = "evaluate_time")
    private String evaluateTime;

    @Column(name = "username")
    private String username;

    @Transient
    private Map<String,EvaluateScore> smallCategoryScoreMap;

    public EvaluateRecord( @NotEmpty String bigCategoryId, String evaluateTime, String username) {
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

    public String getBigCategoryId() {
        return bigCategoryId;
    }

    public void setBigCategoryId(String bigCategoryId) {
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

    public Map<String, EvaluateScore> getSmallCategoryScoreMap() {
        return smallCategoryScoreMap;
    }

    public void setSmallCategoryScoreMap(Map<String, EvaluateScore> smallCategoryScoreMap) {
        this.smallCategoryScoreMap = smallCategoryScoreMap;
    }
}
