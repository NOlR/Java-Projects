package com.jh.vlog.service;

import com.jh.vlog.model.entity.Article;

import java.util.List;

/**
 * @ClassName ArticleService
 * @Description TODO
 * @Author apple
 * @Date 2020/12/15
 **/
public interface ArticleService {
    /**
     * 批量新增文章
     * @param articles
     */
    void insertArticles(List<Article> articles);

    /**
     * 查询所有数据
     * @return
     */
    List<Article> selectAll();
}
