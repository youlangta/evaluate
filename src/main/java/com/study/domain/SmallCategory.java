package com.study.domain;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * 小类
 */
@DynamicUpdate
@DynamicInsert
@Entity
@Table(name = "T_SMALL_CATEGORY")
public class SmallCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "smallCategoryId")
    @GenericGenerator(name = "smallCategoryId", strategy = "com.study.ManulInsertGenerator")
    @Column(name = "small_category_id")
    private int smallCategoryId;

    @Column(name = "small_category_name")
    @NotEmpty
    private String smallCategoryName;
    @Column(name = "big_category_id")
    private int bigCategoryId;

    public SmallCategory(@NotEmpty String smallCategoryName, @NotEmpty int bigCategoryId) {
        this.smallCategoryName = smallCategoryName;
        this.bigCategoryId = bigCategoryId;
    }

    public SmallCategory() {
    }

    public int getSmallCategoryId() {
        return smallCategoryId;
    }

    public void setSmallCategoryId(int smallCategoryId) {
        this.smallCategoryId = smallCategoryId;
    }

    public String getSmallCategoryName() {
        return smallCategoryName;
    }

    public void setSmallCategoryName(String smallCategoryName) {
        this.smallCategoryName = smallCategoryName;
    }

    public int getBigCategoryId() {
        return bigCategoryId;
    }

    public void setBigCategoryId(int bigCategoryId) {
        this.bigCategoryId = bigCategoryId;
    }
}
