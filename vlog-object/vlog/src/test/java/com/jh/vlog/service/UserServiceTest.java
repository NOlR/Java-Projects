package com.jh.vlog.service;

import com.jh.vlog.VlogApplication;
import com.jh.vlog.common.Gender;
import com.jh.vlog.model.dto.LoginDto;
import com.jh.vlog.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = VlogApplication.class)
@Slf4j
class UserServiceTest {

    @Resource
    private UserService userService;
    @Test
    void login() {
        LoginDto loginDto = LoginDto.builder()
                .phone("18796428166")
                .password("222111")
                .build();
        boolean flag = userService.login(loginDto);
        assertTrue(flag);
    }

    @Test
    void getUser() {
        User user = userService.getUser("18796428166");
        log.info(String.valueOf(user));
    }

    @Test
    void updateUser() {
        User user = User.builder()
                .phone("18851199112")
                .password(DigestUtils.md5Hex("123123"))
                .nickname("夏若水")
                .avatar("https://pic-go-noir.oss-cn-beijing.aliyuncs.com/studentmanger/1.jpg")
                .gender(Gender.secret.type)
                .birthday(LocalDate.of(1990,10,24))
                .address("江苏徐州")
                .build();
        userService.updateUser(user);

    }
}