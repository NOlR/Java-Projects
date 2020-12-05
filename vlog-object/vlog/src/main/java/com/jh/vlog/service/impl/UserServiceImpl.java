package com.jh.vlog.service.impl;

import com.jh.vlog.mapper.UserMapper;
import com.jh.vlog.model.dto.LoginDto;
import com.jh.vlog.model.entity.User;
import com.jh.vlog.service.UserService;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.sql.SQLException;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author apple
 * @Date 2020/12/5
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Override
    public boolean login(LoginDto loginDto) {
        User user = getUser(loginDto.getPhone());
        if (user!=null){
            return DigestUtils.md5Hex(loginDto.getPassword()).equals(user.getPassword());
        }
        return false;
    }

    @Override
    public User getUser(String phone) {
        User user = null;
        try {
            user= userMapper.findUserByPhone(phone);
        } catch (SQLException throwables) {
            System.err.println("根据手机号查找用户出现异常");
        }
        return user;
    }
}
