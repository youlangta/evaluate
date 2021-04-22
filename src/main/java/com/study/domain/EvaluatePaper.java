package com.study.domain;

import java.util.List;

/**
 * 测试考题
 */
public class EvaluatePaper {

    private int bigCategoryId;//测评大类
    private String username;//用户名
    private String evaluateTime;//测评时间
    private List<Subject> subjects;//测评试题
    private List<SmallCategory> smallCategorys;//小类种类

    public int getBigCategoryId() {
        return bigCategoryId;
    }

    public void setBigCategoryId(int bigCategoryId) {
        this.bigCategoryId = bigCategoryId;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEvaluateTime() {
        return evaluateTime;
    }

    public void setEvaluateTime(String evaluateTime) {
        this.evaluateTime = evaluateTime;
    }

    public List<SmallCategory> getSmallCategorys() {
        return smallCategorys;
    }

    public void setSmallCategorys(List<SmallCategory> smallCategorys) {
        this.smallCategorys = smallCategorys;
    }
}
