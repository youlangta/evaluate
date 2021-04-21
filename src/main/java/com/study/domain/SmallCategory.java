package com.study.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "T_SMALL_CATEGORY")
public class SmallCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "small_category_id")
    private String smallCategoryId;

    @Column(name = "small_category_name")
    @NotEmpty
    private String smallCategoryName;
    @Column(name = "big_category_id")
    @NotEmpty
    private String bigCategoryId;


    public String getSmallCategoryId() {
        return smallCategoryId;
    }

    public void setSmallCategoryId(String smallCategoryId) {
        this.smallCategoryId = smallCategoryId;
    }

    public String getSmallCategoryName() {
        return smallCategoryName;
    }

    public void setSmallCategoryName(String smallCategoryName) {
        this.smallCategoryName = smallCategoryName;
    }

    public String getBigCategoryId() {
        return bigCategoryId;
    }

    public void setBigCategoryId(String bigCategoryId) {
        this.bigCategoryId = bigCategoryId;
    }
}
