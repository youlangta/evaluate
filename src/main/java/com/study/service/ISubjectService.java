package com.study.service;

import com.study.domain.Subject;

import java.util.List;

public interface ISubjectService {

    List<Subject> queryByBigCategoryId(Integer bigCategoryId);

    List<Subject> queryAll();

    void update(Subject subject);

    void delete(Subject subject);

    void insert(Subject subject);
}
