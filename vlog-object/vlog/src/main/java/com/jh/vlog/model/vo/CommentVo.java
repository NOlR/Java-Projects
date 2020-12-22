package com.jh.vlog.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @ClassName CommentVo
 * @Description TODO
 * @Author apple
 * @Date 2020/12/22
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentVo {
    private Integer id;
    private String articleId;
    private Integer userId;
    private String content;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private LocalDateTime createTime;
    private String nickname;
    private String avatar;

}
