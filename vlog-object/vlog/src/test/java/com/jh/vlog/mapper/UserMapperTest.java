package com.jh.vlog.mapper;

import com.jh.vlog.VlogApplication;
import com.jh.vlog.common.Gender;
import com.jh.vlog.model.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = VlogApplication.class)
@Slf4j
class UserMapperTest {
    @Resource
    private UserMapper userMapper;

    @Test
    void insert() throws Exception {
    User user = User.builder()
            .phone("18796428116")
            .password("222111")
            .nickname("尼古拉斯辉")
            .avatar("1.jpg")
            .gender(Gender.male.type)
            .birthday(LocalDate.now())
            .address("江苏南京")
            .createTime(LocalDateTime.now())
            .build();
    userMapper.insert(user);
    }

    @Test
    void findUserByPhone() throws Exception {
        User user = userMapper.findUserByPhone("18796428116");
        log.info(String.valueOf(user));
    }

    @Test
    void updataUser() throws Exception {
        User user = userMapper.findUserByPhone("18851199112");
        user.setPassword(DigestUtils.md5Hex("123123"));
        user.setNickname("夏若水");
        user.setAvatar("https://pic-go-noir.oss-cn-beijing.aliyuncs.com/studentmanger/1.jpg");
        user.setGender(Gender.female.type);
        user.setBirthday(LocalDate.of(2007,10,24));
        user.setAddress("江苏省南京市江宁区");
        userMapper.updataUser(user);
    }
}