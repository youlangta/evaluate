package com.study.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.*;
import java.util.List;
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "T_COURSE")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "courseId")
    @GenericGenerator(name = "courseId", strategy = "com.study.ManulInsertGenerator")
    @Column(name = "id")//, columnDefinition = "自增主键"
    private int id;
    @Column(name = "COURSE_NAME")
    private String courseName;//课程名称
    @Column(name = "COURSE_CAPTION")
    private String courseCaption;//课程简介
    @Column(name = "COURSE_CONTENT")
    private String courseContent;//课程内容
    @Column(name = "SMALL_CATEGORY_IDS")
    private String smallCategoryIds;//课程对哪些类别有帮助
    @Transient
    private List<SmallCategory> smallCategoryList;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCaption() {
        return courseCaption;
    }

    public void setCourseCaption(String courseCaption) {
        this.courseCaption = courseCaption;
    }

    public String getCourseContent() {
        return courseContent;
    }

    public void setCourseContent(String courseContent) {
        this.courseContent = courseContent;
    }

    public String getSmallCategoryIds() {
        return smallCategoryIds;
    }

    public void setSmallCategoryIds(String smallCategoryIds) {
        this.smallCategoryIds = smallCategoryIds;
    }

    public List<SmallCategory> getSmallCategoryList() {
        return smallCategoryList;
    }

    public void setSmallCategoryList(List<SmallCategory> smallCategoryList) {
        this.smallCategoryList = smallCategoryList;
    }
}
