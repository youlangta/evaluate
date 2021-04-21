package com.study.repository;

import com.study.domain.SmallCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SmallCategoryRepository extends JpaRepository<SmallCategory, String> {

}
