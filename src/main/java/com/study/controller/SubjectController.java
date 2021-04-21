package com.study.controller;

import com.study.domain.BigCategory;
import com.study.domain.Subject;
import com.study.service.IBigCategoryService;
import com.study.service.ISubjectService;
import com.study.utils.ServeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subject")
public class SubjectController {

    @Autowired
    private ISubjectService subjectService;

    @PostMapping("/queryAll")
    public ServeResponse queryAll(){
        return ServeResponse.response(subjectService.queryAll());
    }


    @PostMapping("/update")
    public ServeResponse update(@RequestBody Subject subject){
        subjectService.update(subject);
        return ServeResponse.success();
    }

    @PostMapping("/delete")
    public ServeResponse delete(@RequestBody Subject subject){
        subjectService.delete(subject);
        return ServeResponse.success();
    }

    @PostMapping("/add")
    public ServeResponse add(@RequestBody Subject subject){
        subjectService.insert(subject);
        return ServeResponse.success();
    }

}
