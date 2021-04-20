package com.study.controller;


import com.study.domain.User;
import com.study.service.IUerService;
import com.study.utils.ServeResponse;
import com.study.service.ISessionAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUerService uerService;

    @Autowired
    private ISessionAuthService sessionAuthService;

    /**
     * 登录
     */
    @PostMapping("/login")
    public ServeResponse login(@RequestBody User user) {
        try {
            User login = uerService.login(user);
            return ServeResponse.response(login);
        } catch (Exception e) {
            return ServeResponse.error(e.getMessage());
        }
    }

    /**
     * 注册/新增用户
     */
    @PostMapping("/register")
    public ServeResponse register(@RequestBody User user) {
        try {
            uerService.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
            return ServeResponse.error(e.getMessage());
        }
        return ServeResponse.success();
    }

    /**
     *
     */
    @PostMapping("/updatePassword")
    public ServeResponse updatePassword(@RequestBody User user) {
        try {
            uerService.updatePassword(user);
            return ServeResponse.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ServeResponse.error(e.getMessage());
        }
    }

    /**
     * 退出登陆
     */
    @GetMapping("/logout")
    public ServeResponse logout(HttpServletRequest request) {
        String authentication = request.getHeader("authentication");
        sessionAuthService.logout(authentication);
        return ServeResponse.success();
    }

    /**
     * 验证会话是否有效
     */
    @GetMapping("/isValid")
    public ServeResponse isValid(HttpServletRequest request) {
        String authentication = request.getHeader("authentication");
        return ServeResponse.response(sessionAuthService.isValid(authentication));
    }

    /**
     * 获取当前登录的用户
     */
    @GetMapping("/get/user")
    public ServeResponse getCurrentLoginUser(HttpServletRequest request) {
        String authentication = request.getHeader("authentication");
        User userBySession = sessionAuthService.getUserBySession(authentication);
        return ServeResponse.response(userBySession);
    }

}
