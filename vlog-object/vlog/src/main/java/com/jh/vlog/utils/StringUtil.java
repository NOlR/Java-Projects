package com.jh.vlog.utils;

import java.util.Random;

/**
 * @ClassName StringUtil
 * @Description TODO
 * @Author apple
 * @Date 2020/12/6
 **/
public class StringUtil {
    public static String getVerifyCode(){
        Random random=new Random();
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<6;i++){
            stringBuilder.append(String.valueOf(random.nextInt(10)));
        }
        return stringBuilder.toString();
    }
}
