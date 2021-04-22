package com.study.service.impl;

import com.study.domain.Course;
import com.study.domain.SmallCategory;
import com.study.domain.Subject;
import com.study.repository.CourseRepository;
import com.study.repository.SmallCategoryRepository;
import com.study.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SmallCategoryRepository smallCategoryRepository;

    @Override
    public List<Course> queryAll() {
        List<Course> courses = courseRepository.findAll();
        for(Course course : courses){
            String[] splits = course.getSmallCategoryIds().split(",");
            List<Integer> smallCategoryValues = new ArrayList<>();
            for(String split : splits){
                if(split!=null && split.trim().length()>0){
                    smallCategoryValues.add(Integer.valueOf(split.trim()));
                }
            }
            List<SmallCategory> smallCategories =
                    smallCategoryRepository.findAllById(smallCategoryValues);
            course.setSmallCategoryList(smallCategories);
        }
        return courses;
    }

    @Override
    public void update(Course course) {
        courseRepository.deleteById(course.getId());
        courseRepository.save(course);
    }

    @Override
    public void delete(Course course) {
        courseRepository.deleteById(course.getId());
    }

    @Override
    public void insert(Course course) {
        courseRepository.save(course);
    }

}
