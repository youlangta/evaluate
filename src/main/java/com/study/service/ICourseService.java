package com.study.service;

import com.study.domain.Course;
import com.study.domain.Subject;

import java.util.List;

public interface ICourseService {
    List<Course> queryAll();

    void update(Course course);

    void delete(Course course);

    void insert(Course course);
}
