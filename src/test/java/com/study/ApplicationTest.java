package com.study;

import com.study.domain.User;
import com.study.repository.UserRepository;
import com.study.service.IUerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTest {
    @Autowired
    private IUerService uerService;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void userTest(){
        userRepository.deleteAll();
        User user = new User();
        user.setUsername("caohui");
        user.setPassword("123123");
        user.setEmail("lll");
        user.setPhoneNum("333");

        uerService.insert(user);
        System.out.println("user:"+user);
        User login = uerService.login(user);
        System.out.println("login:"+login);
        login.setPassword("333333");
        uerService.updatePassword(login);
        login = uerService.login(user);
        System.out.println("login:"+login);
    }


}
