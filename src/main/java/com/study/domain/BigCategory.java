package com.study.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 大类
 */
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "T_BIG_CATEGORY")
public class BigCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "bigCategoryId")
    @GenericGenerator(name = "bigCategoryId", strategy = "com.study.ManulInsertGenerator")
    @Column(name = "big_category_id")
    private int bigCategoryId;
    @Column(name = "big_category_name")
    @NotEmpty
    private String bigCategoryName;
    @Column(name = "BIG_CATEGORY_CAPTION")
    private String bigCategoryCaption;//大类简介
    @Column(name = "BIG_CATEGORY_IMAGE",columnDefinition="longblob")
    private String bigCategoryImage ;//图片

    @Transient
    private List<SmallCategory> smallCategories;

    public int getBigCategoryId() {
        return bigCategoryId;
    }

    public void setBigCategoryId(int bigCategoryId) {
        this.bigCategoryId = bigCategoryId;
    }

    public String getBigCategoryName() {
        return bigCategoryName;
    }

    public void setBigCategoryName(String bigCategoryName) {
        this.bigCategoryName = bigCategoryName;
    }


    public List<SmallCategory> getSmallCategories() {
        return smallCategories;
    }

    public void setSmallCategories(List<SmallCategory> smallCategories) {
        this.smallCategories = smallCategories;
    }

    public String getBigCategoryCaption() {
        return bigCategoryCaption;
    }

    public void setBigCategoryCaption(String bigCategoryCaption) {
        this.bigCategoryCaption = bigCategoryCaption;
    }

    public String getBigCategoryImage() {
        return bigCategoryImage;
    }

    public void setBigCategoryImage(String bigCategoryImage) {
        this.bigCategoryImage = bigCategoryImage;
    }
}
