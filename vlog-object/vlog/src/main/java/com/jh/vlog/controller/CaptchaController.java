package com.jh.vlog.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.jh.vlog.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @ClassName CaptchaController
 * @Description 验证码接口
 * @Author apple
 * @Date 2020/12/10
 **/
@RestController
@RequestMapping(value = "api")
@Slf4j
public class CaptchaController {
    @Resource
    private DefaultKaptcha defaultKaptcha;
    @Resource
    private RedisService redisService;

    @GetMapping("captcha")
    public void setDefaultKaptcha(@RequestParam String phone){
        //取得HttpServletPesonse对象
        ServletRequestAttributes sra = (ServletRequestAttributes)
                RequestContextHolder.getRequestAttributes();
        assert sra!=null;
        HttpServletResponse response = sra.getResponse();
        //生成验证码文本
        String text = defaultKaptcha.createText();
        log.info(text);
        //将验证码存入redis，配置的失效时间是2分钟
        redisService.set(phone,text,2L);
        //生成图片验证码,并通过response输出到客户端浏览器
        BufferedImage image = defaultKaptcha.createImage(text);
        //设置response的相应内容类型为图片格式
        assert response !=null;
        response.setContentType("image/jpeg");
        response.setDateHeader("Expires",0);
        try {
            ImageIO.write(image,"jpg",response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
