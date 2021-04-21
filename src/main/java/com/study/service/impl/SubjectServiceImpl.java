package com.study.service.impl;

import com.study.domain.Subject;
import com.study.repository.SubjectRepository;
import com.study.service.ISubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements ISubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public List<Subject> queryByBigCategoryId(String bigCategoryId) {
        return subjectRepository.queryByBigCateroy(bigCategoryId);
    }

    @Override
    public List<Subject> queryAll() {
        return subjectRepository.findAll();
    }

    @Override
    public void update(Subject subject) {
        subjectRepository.delete(subject);
        subjectRepository.save(subject);
    }

    @Override
    public void delete(Subject subject) {
        subjectRepository.delete(subject);
    }

    @Override
    public void insert(Subject subject) {
        subjectRepository.save(subject);
    }
}
