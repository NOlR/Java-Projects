package com.jh.vlog.service;

import com.jh.vlog.VlogApplication;
import com.jh.vlog.model.dto.LoginDto;
import com.jh.vlog.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = VlogApplication.class)
@Slf4j
class UserServiceTest {

    @Resource
    private UserService userService;
    @Test
    void login() {
        LoginDto loginDto = LoginDto.builder()
                .phone("18796428116")
                .password("222111")
                .build();
        boolean flag = userService.login(loginDto);
        assertTrue(flag);
    }

    @Test
    void getUser() {
        User user = userService.getUser("18796428116");
        log.info(String.valueOf(user));
    }
}