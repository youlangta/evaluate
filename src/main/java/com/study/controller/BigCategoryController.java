package com.study.controller;

import com.study.domain.BigCategory;
import com.study.service.IBigCategoryService;
import com.study.utils.ServeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/category")
public class BigCategoryController {

    @Autowired
    private IBigCategoryService bigCategoryService;

    @PostMapping("/queryAll")
    public ServeResponse queryAll(){
        return ServeResponse.response(bigCategoryService.queryAll());
    }


    @PostMapping("/update")
    public ServeResponse update(@RequestBody BigCategory bigCategory){
        bigCategoryService.update(bigCategory);
        return ServeResponse.success();
    }

    @PostMapping("/delete")
    public ServeResponse delete(@RequestBody BigCategory bigCategory){
        bigCategoryService.delete(bigCategory);
        return ServeResponse.success();
    }

    @PostMapping("/add")
    public ServeResponse add(@RequestBody BigCategory bigCategory){
        bigCategoryService.insert(bigCategory);
        return ServeResponse.success();
    }

}
