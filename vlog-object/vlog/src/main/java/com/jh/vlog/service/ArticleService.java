package com.jh.vlog.service;

import com.github.pagehelper.PageInfo;
import com.jh.vlog.model.entity.Article;
import com.jh.vlog.model.vo.ArticleVo;
import org.apache.ibatis.annotations.Param;

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
     * 查询推荐的6篇文章
     * @param userId
     * @return
     */
    List<ArticleVo> getRecommendArticles(@Param(value = "userId") int userId);

    /**
     * 根据用户id查询数据并分页
     * @param pageNum 页码
     * @param pageSize  每页数量
     * @param
     * @return  返回结果
     */
    PageInfo<ArticleVo> selectByPage(int pageNum,int pageSize);

    /**
     * 根据文章id查找文章详情
     * @param id
     * @return
     */
    Article getDetail(@Param(value = "id")String id);

    /**
     * 发布文章
     * @param article
     * @return
     */
    Article postArticle(Article article);
}
