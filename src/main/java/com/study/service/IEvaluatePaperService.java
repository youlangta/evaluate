package com.study.service;

import com.study.domain.EvaluatePaper;
import com.study.domain.EvaluateRecord;


public interface IEvaluatePaperService {


    EvaluatePaper createNew(Integer bigCategoryId);

    EvaluateRecord insert(EvaluatePaper evaluatePaper);

}
