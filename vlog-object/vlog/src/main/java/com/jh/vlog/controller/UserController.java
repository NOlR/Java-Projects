package com.jh.vlog.controller;

import com.jh.vlog.common.ResponseResult;
import com.jh.vlog.common.ResultCode;
import com.jh.vlog.model.dto.LoginDto;
import com.jh.vlog.model.dto.PhoneLoginDto;
import com.jh.vlog.model.entity.User;
import com.jh.vlog.service.RedisService;
import com.jh.vlog.service.UserService;
import com.jh.vlog.utils.SmsUtil;
import com.jh.vlog.utils.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @Resource
    private SmsUtil smsUtil;
    @Resource
    private RedisService redisService;

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

    @PostMapping(value = "/sendcode")
    public ResponseResult sendCode(@RequestParam String phone){
        //随机验证码
        String code= StringUtil.getVerifyCode();
        //给入参手机号发送短信
        boolean flag = smsUtil.sendSms(phone,code);
        if (flag){
            //验证码存入redis,1分钟有效
            redisService.set(phone,code,1L);
            return ResponseResult.success(code);
        }else {
            redisService.set(phone,code,1L);
            return ResponseResult.failure(ResultCode.SMS_ERROR);
        }
    }

    @PostMapping(value = "/phonelogin")
    public ResponseResult login(@RequestBody PhoneLoginDto phoneLoginDto){
        log.info("phoneLoginDto:"+phoneLoginDto);
        boolean flag = userService.phoneLogin(phoneLoginDto);
        if (flag){
            return  ResponseResult.success(userService.getUser(phoneLoginDto.getPhone()));
        }else {
            return ResponseResult.failure(ResultCode.USER_VERIFY_CODE_ERROR);
        }

    }

    @PostMapping(value = "/update")
    public ResponseResult update(@RequestBody User user){
        log.info("user:"+user);
        User newUser = userService.updateUser(user);
        return ResponseResult.success(newUser);
    }
}
