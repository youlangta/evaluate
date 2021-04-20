package com.study.service.impl;

import com.study.domain.User;
import com.study.repository.UserRepository;
import com.study.service.IUerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UerServiceImpl implements IUerService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User login(User user) {
        return userRepository.login(user);
    }

    @Override
    public void insert(User user) {
        userRepository.save(user);
    }

    @Override
    public void updatePassword(User user) {
        userRepository.updatePassword(user);
    }
}
