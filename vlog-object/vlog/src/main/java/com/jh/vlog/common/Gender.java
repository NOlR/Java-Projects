package com.jh.vlog.common;

/**
 * @ClassName Gender
 * @Description 性别枚举
 * @Author apple
 * @Date 2020/12/5
 **/
public enum Gender {
    male(1,"男"),
    female(2,"女"),
    secret(0,"保密");
    public final Integer type;
    public final String value;
    Gender(Integer type,String value){
        this.type = type;
        this.value = value;
    }
}
