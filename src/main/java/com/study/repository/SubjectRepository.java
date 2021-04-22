package com.study.repository;

import com.study.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    @Query("select s from Subject s where s.bigCategoryId = :bigCategoryId")
    List<Subject> queryByBigCateroy(@Param("bigCategoryId")int bigCategoryId);



}
