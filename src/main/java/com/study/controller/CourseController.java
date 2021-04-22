package com.study.controller;

import com.study.domain.Course;
import com.study.domain.Subject;
import com.study.service.ICourseService;
import com.study.utils.ServeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseController {
    @Autowired
    private ICourseService courseService;

    @PostMapping("/queryAll")
    public ServeResponse queryAll(){
        return ServeResponse.response(courseService.queryAll());
    }


    @PostMapping("/update")
    public ServeResponse update(@RequestBody Course course){
        courseService.update(course);
        return ServeResponse.success();
    }

    @PostMapping("/delete")
    public ServeResponse delete(@RequestBody Course course){
        courseService.delete(course);
        return ServeResponse.success();
    }

    @PostMapping("/add")
    public ServeResponse add(@RequestBody Course course){
        courseService.insert(course);
        return ServeResponse.success();
    }

}
