package com.study.repository;

import com.study.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
