package com.study.repository;

import com.study.domain.SmallCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface SmallCategoryRepository extends JpaRepository<SmallCategory, Integer> {
    @Query("select s from SmallCategory s where s.bigCategoryId = :bigCategoryId")
    List<SmallCategory> queryByBigCategory(@Param("bigCategoryId")int bigCategoryId);

    @Query("delete from SmallCategory s where s.bigCategoryId = :bigCategoryId")
    void deleteByBigCategory(@Param("bigCategoryId")int bigCategoryId);
}
