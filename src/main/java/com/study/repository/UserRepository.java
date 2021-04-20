package com.study.repository;

import com.study.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.username = :#{#user.username} and u.password = :#{#user.password}")
    User login(User user);

    @Query("update User u set  u.password = :#{#user.password} where u.username = :#{#user.username}")
    @Modifying
    int updatePassword(User user);
}
