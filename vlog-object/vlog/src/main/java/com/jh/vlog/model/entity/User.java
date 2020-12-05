package com.jh.vlog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @ClassName User
 * @Description TODO
 * @Author apple
 * @Date 2020/12/5
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    private Integer id;
    private String wxOpenId;
    private String phone;
    private String password;
    private String nickname;
    private String avatar;
    private Integer gender;
    private LocalDate birthday;
    private String address;
    private LocalDateTime createTime;

}
