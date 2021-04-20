package com.study.service;


import com.study.domain.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public interface ISessionAuthService {

    Map<String, User> USER_LOGIN = new ConcurrentHashMap<>();

    ThreadLocal<User> USERS_THREAD = new ThreadLocal<>();

    /**
     * 记录登录的用户
     */
    void setLoginUser(String sessionId, User user);

    /**
     * 退出
     */
    void logout(String sessionId);

    /**
     * 是否有效
     */
    boolean isValid(String sessionId);

    /**
     * 根据sessionId获取用户
     */
    User getUserBySession(String sessionId);

    /**
     * 为当前线程设置用户
     */
    void setCurrentUserThread(User user);

    /**
     * 获取当前线程的 用户
     */
    User getCurrentUserThread();
}
