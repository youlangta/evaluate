package com.study.service;

import com.study.domain.BigCategory;

import java.util.List;

public interface IBigCategoryService {

    List<BigCategory> queryAll();

    void update(BigCategory bigCategory);

    void insert(BigCategory bigCategory);

    void delete(BigCategory bigCategory);

}
