package com.jh.vlog.utils;

import com.jh.vlog.model.Card;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @ClassName DataUtil
 * @Description TODO
 * @Author apple
 * @Date 2020/12/3
 **/
public class DataUtil {
    public static List<Card> initCards() {
        Card[] cards = new Card[]{
                Card.builder()
                        .id(1)
                        .title("Java学习")
                        .bgImg("https://pic-go-noir.oss-cn-beijing.aliyuncs.com/studentmanger/1.jpg")
                        .content("Java学习")
                        .build(),
                Card.builder()
                        .id(1)
                        .title("JavaScript学习")
                        .bgImg("https://pic-go-noir.oss-cn-beijing.aliyuncs.com/studentmanger/2.jpg")
                        .content("JavaScript学习")
                        .build(),
                Card.builder()
                        .id(1)
                        .title("Linux学习")
                        .bgImg("https://pic-go-noir.oss-cn-beijing.aliyuncs.com/studentmanger/3.jpg")
                        .content("Linux学习")
                        .build(),
                Card.builder()
                        .id(1)
                        .title("MySQL学习")
                        .bgImg("https://pic-go-noir.oss-cn-beijing.aliyuncs.com/studentmanger/4.jpg")
                        .content("MySQL学习")
                        .build(),
                Card.builder()
                        .id(1)
                        .title("Python学习")
                        .bgImg("https://pic-go-noir.oss-cn-beijing.aliyuncs.com/studentmanger/5.jpg")
                        .content("Python学习")
                        .build()
        };
        return Arrays.asList(cards);
    }

    public static String getTotalWords() {
        Random random = new Random();
        int total = random.nextInt(9000) + 1000;
        DecimalFormat df = new DecimalFormat("0.0");
        //2.6k的形式，保留一位小数
        return df.format(total / 1000.0) + "k";
    }

    public static int getUserId() {
        Random random = new Random();
        return random.nextInt(3) + 1;
    }

    public static int getDuration() {
        Random random = new Random();
        //[2,11]
        return random.nextInt(10) + 2;
    }

    public static int getPageView() {
        Random random = new Random();
        //随机四位数
        return random.nextInt(9000) + 1000;
    }
}
