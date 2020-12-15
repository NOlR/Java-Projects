package com.jh.vlog.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ArticleTag
 * @Description TODO
 * @Author apple
 * @Date 2020/12/15
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleTag {
    private Integer id;
    private String articleId;
    private String tagName;
}
