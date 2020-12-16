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
    @Insert({
            "<script>",
            "INSERT INTO t_article (id,category,user_id,title,cover,summary,content,url,publish_date) VALUES ",
            "<foreach collection='articleList' item='item' index='index' separator=','>",
            "(#{item.id},#{item.category},#{item.userId},#{item.title},#{item.cover},#{item.summary},#{item.content},"+
                    "#{item.url},#{item.publishDate})",
            "</foreach>",
            "</script>"
    })
    int insertArticles(@Param(value = "articleList") List<Article> articleList);


    @Select("SELECT * FROM t_article a WHERE a.user_id = #{userId} ")
        @Results({
                @Result(id = true,property = "id",column = "id"),
                @Result(property = "category",column = "category"),
                @Result(property = "userId",column = "user_id"),
                @Result(property = "title",column = "title"),
                @Result(property = "cover",column = "cover"),
                @Result(property = "summary",column = "summary"),
                @Result(property = "content",column = "content"),
                @Result(property = "url",column = "url"),
                @Result(property = "publishDate",column = "publish_date"),
                @Result(property = "tagList",column = "id",
                many = @Many(select = "com.jh.vlog.mapper.ArticleTagMapper.selectByArticleId"))
        })
       Page<Article> selectAll(@Param(value = "userId") int userId);
}

