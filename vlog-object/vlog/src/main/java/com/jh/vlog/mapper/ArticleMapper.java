package com.jh.vlog.mapper;

import com.jh.vlog.model.entity.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
            "INSERT INTO t_article (id,category,user_id,title,cover,summary,content,url,publish_date,create_time) VALUES ",
            "<foreach collection='articleList' item='item' index='index' separator=','>",
            "(#{item.id},#{item.category},#{item.userId},#{item.title},#{item.cover},#{item.summary},#{item.content},"+
                    "#{item.url},#{item.publishDate},#{item.createTime})",
            "</foreach>",
            "</script>"
    })
    int insertArticles(@Param(value = "articleList") List<Article> articleList);

    /**
     * 查询所有文章
     * @return
     */
    @Select("SELECT * FROM t_article ORDER BY create_time")
    List<Article> selectAll();
}
