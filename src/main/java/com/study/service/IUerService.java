package com.study.service;

import com.study.domain.User;

public interface IUerService {
    User login(User user);

    void insert(User user);

    void updatePassword(User user);
}
