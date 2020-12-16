package com.jh.vlog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName Article
 * @Description TODO
 * @Author apple
 * @Date 2020/12/15
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Article {
    private String id;
    private String category;
    private Integer userId;
    private String title;
    private String cover;
    private String summary;
    private String content;
    private String url;
    //爬取时间
    private LocalDate publishDate;
    private List<ArticleTag> tagList;
}
