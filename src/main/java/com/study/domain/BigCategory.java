package com.study.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * 大类
 */
@Entity
@Table(name = "T_BIG_CATEGORY")
public class BigCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "big_category_id")
    private String bigCategoryId;
    @Column(name = "big_category_name")
    @NotEmpty
    private String bigCategoryName;
    @Transient
    private List<SmallCategory> smallCategories;

    public String getBigCategoryId() {
        return bigCategoryId;
    }

    public void setBigCategoryId(String bigCategoryId) {
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
}
