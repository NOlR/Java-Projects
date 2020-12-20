package com.jh.vlog.mapper;

import com.github.pagehelper.Page;
import com.jh.vlog.model.entity.Article;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @ClassName ArticleMapper
 * @Description 批量插入文章
 * @Author apple
 * @Date 2020/12/15
 **/
public interface ArticleMapper {

    /**
     * 新增文章
     * @param article
     */
    @Insert("INSERT INTO t_article (id,category,user_id,title,cover,summary,content,publish_date,total_words,duration,page_view) "+
    "VALUES (#{article.id},#{article.category},#{article.userId},#{article.title},#{article.cover},#{article.summary},#{article.content}," +
            "#{article.publishDate},#{article.totalWords},#{article.duration},#{article.pageView})")
    void add(@Param("article") Article article);
    @Insert({
            "<script>",
            "INSERT INTO t_article (id,category,user_id,title,cover,summary,content,url,publish_date,total_words,duration,page_view) VALUES ",
            "<foreach collection='articleList' item='item' index='index' separator=','>",
            "(#{item.id},#{item.category},#{item.userId},#{item.title},#{item.cover},#{item.summary},#{item.content},"+
                    "#{item.url},#{item.publishDate},#{item.totalWords},#{item.duration},#{item.pageView})",
            "</foreach>",
            "</script>"
    })
    int insertArticles(@Param(value = "articleList") List<Article> articleList);

    /**
     * 查询某个用户的6篇文章
     * @param userId
     * @return
     */
    @Select("SELECT id,category,user_id,title,cover,summary FROM t_article WHERE user_id=#{userId} ORDER BY page_view DESC LIMIT 6 ")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "category",column = "category"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "title",column = "title"),
            @Result(property = "cover",column = "cover"),
            @Result(property = "summary",column = "summary")
    })
    List<Article> getRecommendArticles(@Param(value = "userId") int userId);


    @Select("SELECT id,category,user_id,title,cover,summary,publish_date FROM t_article a WHERE a.user_id = #{userId} ")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "category",column = "category"),
            @Result(property = "userId",column = "user_id"),
            @Result(property = "title",column = "title"),
            @Result(property = "cover",column = "cover"),
            @Result(property = "summary",column = "summary"),
            @Result(property = "publishDate",column = "publish_date"),
            @Result(property = "tagList",column = "id",
                    many = @Many(select = "com.jh.vlog.mapper.ArticleTagMapper.selectByArticleId"))
    })
    Page<Article> selectAll(@Param(value = "userId") int userId);

    /**
     * 根据文章id查找文章详情
     * @param id
     * @return
     */
    @Select("SELECT * FROM t_article WHERE id = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "category",column = "catgory"),
            @Result(property = "userId",column = "userId"),
            @Result(property = "title",column = "title"),
            @Result(property = "cover",column = "cover"),
            @Result(property = "content",column = "content"),
            @Result(property = "publishDate",column = "publish_date"),
            @Result(property = "totalWords",column = "toral_words"),
            @Result(property = "duration",column = "durations"),
            @Result(property = "pageView",column = "page_view"),
            @Result(property = "tagList",column = "id",
            many = @Many(select = "com.jh.vlog.mapper.ArticleTagMapper.selectByArticleId"))
    })
    Article getDetail(@Param(value = "id")String id);
}

