package com.study.controller;

import com.study.service.IEvaluateRecordService;
import com.study.utils.ServeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evaluateRecord")
public class EvaluateRecordController {

    @Autowired
    private IEvaluateRecordService evaluateRecordService;

    @PostMapping("/queryAll")
    public ServeResponse queryAll(){
        return ServeResponse.response(evaluateRecordService.queryAll());
    }

    @GetMapping("/query")
    public ServeResponse query(@RequestParam("evaluateId") String evaluateId){
        return ServeResponse.response(evaluateRecordService.query(evaluateId));
    }

}
