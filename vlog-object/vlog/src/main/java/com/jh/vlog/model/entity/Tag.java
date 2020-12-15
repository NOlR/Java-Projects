package com.jh.vlog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName Tag
 * @Description TODO
 * @Author apple
 * @Date 2020/12/13
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tag {
    private Integer id;
    private String tagName;
    private String tagColor;
}
