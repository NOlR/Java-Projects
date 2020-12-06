package com.jh.vlog.utils;

import com.aliyuncs.exceptions.ClientException;
import com.jh.vlog.VlogApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = VlogApplication.class)
@Slf4j
class SmsUtilTest {

    @Resource
    private SmsUtil smsUtil;
    @Test
    void sendSms() throws ClientException {
        smsUtil.sendSms("18796428166","123123");
    }
}