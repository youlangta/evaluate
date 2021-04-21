package com.study.domain;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "T_BIG_CATEGORY")
public class BIgCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "big_category_id")
    private String bigCategoryId;
    @Column(name = "big_category_name")
    @NotEmpty
    private String bigCategoryName;


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
}
