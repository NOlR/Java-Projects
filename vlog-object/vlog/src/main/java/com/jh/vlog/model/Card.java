package com.jh.vlog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Card
 * @Description TODO
 * @Author apple
 * @Date 2020/12/3
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Card {
    private Integer id;
    private String title;
    private String bgImg;
    private String content;
}
