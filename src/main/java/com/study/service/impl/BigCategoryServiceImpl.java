package com.study.service.impl;

import com.study.domain.BigCategory;
import com.study.domain.SmallCategory;
import com.study.repository.BigCategoryRepository;
import com.study.repository.SmallCategoryRepository;
import com.study.service.IBigCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BigCategoryServiceImpl implements IBigCategoryService {
    @Autowired
    private BigCategoryRepository bigCategoryRepository;

    @Autowired
    private SmallCategoryRepository smallCategoryRepository;

    @Override
    public List<BigCategory> queryAll() {
        List<BigCategory> bigCategories = bigCategoryRepository.findAll();
        for(BigCategory bigCategory:bigCategories){
            bigCategory.setSmallCategories(smallCategoryRepository.queryByBigCategory(bigCategory.getBigCategoryId()));
        }
        return bigCategories;
    }

    @Override
    public void update(BigCategory bigCategory) {
        bigCategoryRepository.save(bigCategory);
        bigCategory.getSmallCategories().forEach(smallCategory -> {
            smallCategory.setBigCategoryId(bigCategory.getBigCategoryId());
        });
        smallCategoryRepository.saveAll(bigCategory.getSmallCategories());
    }

    @Override
    public void insert(BigCategory bigCategory) {
        BigCategory fushBigCategory =  bigCategoryRepository.saveAndFlush(bigCategory);
        bigCategory.getSmallCategories().forEach(smallCategory -> {
            smallCategory.setBigCategoryId(fushBigCategory.getBigCategoryId());
        });
        smallCategoryRepository.saveAll(bigCategory.getSmallCategories());
    }

    @Override
    public void delete(BigCategory bigCategory) {
        bigCategoryRepository.delete(bigCategory);
        smallCategoryRepository.deleteByBigCategory(bigCategory.getBigCategoryId());
    }
}
