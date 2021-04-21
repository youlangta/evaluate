package com.study.controller;

import com.study.domain.EvaluatePaper;
import com.study.domain.EvaluateRecord;
import com.study.service.IEvaluatePaperService;
import com.study.utils.ServeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/evaluate")
public class EvaluatePaperController {

    @Autowired
    private IEvaluatePaperService evaluatePaperService;

    /**
     * 生成一份测评数据
     * @param evaluatePaper
     * @return
     */
    @PostMapping("/createNew")
    public ServeResponse createNew(@RequestBody EvaluatePaper evaluatePaper){
        EvaluatePaper result = evaluatePaperService.createNew(evaluatePaper.getBigCategoryId());
        return ServeResponse.response(result);
    }

    /**
     * 测评结束
     * @param evaluatePaper
     * @return
     */
    @PostMapping("/insert")
    public ServeResponse insert(@RequestBody EvaluatePaper evaluatePaper){
        EvaluateRecord evaluateRecord = evaluatePaperService.insert(evaluatePaper);
        return ServeResponse.response(evaluateRecord);
    }


}
