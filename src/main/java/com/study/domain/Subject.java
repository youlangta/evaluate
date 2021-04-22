package com.study.domain;

import com.alibaba.fastjson.JSON;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * 测评试题
 */
@Entity
@Table(name = "T_SUBJECT")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")//, columnDefinition = "自增主键"
    private int id;
    @Column(name = "SUBJECT_CONENT")
    private String subjectConent;//试题内容
    @Column(name = "SUBJECT_WEIGHT")
    private int subjectWeight;//试题权重
    @Column(name = "ANSWER0")
    private String answer0;//选项0
    @Column(name = "ANSWER1")
    private String answer1;//选项1
    @Column(name = "ANSWER2")
    private String answer2;//选项2
    @Column(name = "ANSWER3")
    private String answer3;//选项3
    @Column(name = "SUBJECT_ANSWER")
    private int subjectAnswer;//试题答案
    @Column(name = "small_category_id")
    @NotEmpty
    private int smallCategoryId;//小类
    @Column(name = "big_category_id")
    @NotEmpty
    private int bigCategoryId;//大类
    @Transient
    private int evaluateAnswer = -1;//测评结果答案
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubjectConent() {
        return subjectConent;
    }

    public void setSubjectConent(String subjectConent) {
        this.subjectConent = subjectConent;
    }

    public int getSubjectWeight() {
        return subjectWeight;
    }

    public void setSubjectWeight(int subjectWeight) {
        this.subjectWeight = subjectWeight;
    }

    public String getAnswer0() {
        return answer0;
    }

    public void setAnswer0(String answer0) {
        this.answer0 = answer0;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public int getSubjectAnswer() {
        return subjectAnswer;
    }

    public void setSubjectAnswer(int subjectAnswer) {
        this.subjectAnswer = subjectAnswer;
    }

    public int getSmallCategoryId() {
        return smallCategoryId;
    }

    public void setSmallCategoryId(int smallCategoryId) {
        this.smallCategoryId = smallCategoryId;
    }

    public int getBigCategoryId() {
        return bigCategoryId;
    }

    public void setBigCategoryId(int bigCategoryId) {
        this.bigCategoryId = bigCategoryId;
    }

    public int getEvaluateAnswer() {
        return evaluateAnswer;
    }

    public void setEvaluateAnswer(int evaluateAnswer) {
        this.evaluateAnswer = evaluateAnswer;
    }
}
