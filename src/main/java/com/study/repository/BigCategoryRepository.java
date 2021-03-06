package com.study.repository;

import com.study.domain.BigCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface BigCategoryRepository extends JpaRepository<BigCategory, Integer> {
}
