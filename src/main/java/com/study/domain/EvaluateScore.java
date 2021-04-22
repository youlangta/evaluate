package com.study.domain;

import javax.persistence.*;

@Entity
@Table(name = "T_EVALUATE_SCORE")
public class EvaluateScore {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")//, columnDefinition = "自增主键"
    private int id;
    @Column(name = "evaluate_id")
    private int evaluateId;
    @Column(name = "small_category_id")
    private int smallCategoryId;
    @Column(name = "score")
    private int score;

    public EvaluateScore() {
    }

    public EvaluateScore(int evaluateId, int smallCategoryId, int score) {
        this.evaluateId = evaluateId;
        this.smallCategoryId = smallCategoryId;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEvaluateId() {
        return evaluateId;
    }

    public void setEvaluateId(int evaluateId) {
        this.evaluateId = evaluateId;
    }

    public int getSmallCategoryId() {
        return smallCategoryId;
    }

    public void setSmallCategoryId(int smallCategoryId) {
        this.smallCategoryId = smallCategoryId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
