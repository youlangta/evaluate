package com.study.service.impl;

import com.study.domain.User;
import com.study.service.ISessionAuthService;
import org.springframework.stereotype.Service;


@Service
public class SessionAuthServiceImpl implements ISessionAuthService {

    /**
     * 记录登录的用户
     */
    @Override
    public void setLoginUser(String sessionId, User user){
        USER_LOGIN.put(sessionId,user);
    }
    /**
     * 根据sessionId获取用户
     */
    @Override
    public User getUserBySession(String sessionId){
        return USER_LOGIN.get(sessionId);
    }
    /**
     * 退出
     */
    @Override
    public void logout(String sessionId){
        USER_LOGIN.remove(sessionId);
    }
    /**
     * 是否有效
     */
    @Override
    public boolean isValid(String sessionId){
        if(USER_LOGIN.get(sessionId) != null){
            return  true;
        }else{
            return false;
        }
    }




    @Override
    public void setCurrentUserThread(User user){
        USERS_THREAD.set(user);
    }

    @Override
    public User getCurrentUserThread(){
        return USERS_THREAD.get();
    }
}
