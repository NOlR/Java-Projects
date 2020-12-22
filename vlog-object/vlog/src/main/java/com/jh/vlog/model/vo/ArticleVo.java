package com.jh.vlog.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jh.vlog.model.entity.ArticleTag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName ArticleVo
 * @Description TODO
 * @Author apple
 * @Date 2020/12/21
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleVo {
    private String id;
    private String category;
    private Integer userId;
    private String title;
    private String cover;
    private String summary;
    private String content;
    private String url;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private LocalDateTime createTime;
    private String totalWords;
    private Integer duration;
    private Integer pageView;
    private List<ArticleTag> tagList;
    private String nickname;
    private String avatar;

}
