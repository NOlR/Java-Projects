package com.jh.vlog.controller;

import com.jh.vlog.common.ResponseResult;
import com.jh.vlog.common.ResultCode;
import com.jh.vlog.model.dto.LoginDto;
import com.jh.vlog.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.net.ResponseCache;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author apple
 * @Date 2020/12/5
 **/
@RestController
@RequestMapping(value = "/api/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping(value = "/login")
    ResponseResult login(@RequestBody LoginDto loginDto){
        log.info("loginDto:"+loginDto);
        boolean flag = userService.login(loginDto);
        if (flag){
            return ResponseResult.success(userService.getUser(loginDto.getPhone()));
        }else {
            return ResponseResult.failure(ResultCode.USER_SIGN_IN_FAIL);
        }

    }
}
