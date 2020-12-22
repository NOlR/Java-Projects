package com.jh.vlog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @ClassName Comment
 * @Description TODO
 * @Author apple
 * @Date 2020/12/22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    private Integer id;
    private String articleId;
    private Integer userId;
    private String content;
    private LocalDateTime createTime;
}
