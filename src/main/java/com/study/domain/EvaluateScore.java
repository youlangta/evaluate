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
    private String smallCategoryId;
    @Column(name = "score")
    private int score;


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

    public String getSmallCategoryId() {
        return smallCategoryId;
    }

    public void setSmallCategoryId(String smallCategoryId) {
        this.smallCategoryId = smallCategoryId;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
