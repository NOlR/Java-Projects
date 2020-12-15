package com.jh.vlog.mapper;

import com.jh.vlog.model.entity.ArticleTag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName ArticleTagMapper
 * @Description TODO
 * @Author apple
 * @Date 2020/12/15
 **/
public interface ArticleTagMapper {
    /**
     * 批量插入操作
     * @param articleTagList
     */
    @Insert({
            "<script>",
            "INSERT INTO t_article_tag (article_id,tag_name) VALUES ",
            "<foreach collection='articleTagList' item='item' index='index' separator=','>",
            "(#{item.articleId},#{item.tagName})",
            "</foreach>",
            "</script>"
    })
    void insertArticleTags(@Param(value = "articleTagList") List<ArticleTag> articleTagList);

    /**
     * 查询指定文章的所有标签
     * @param articleId
     * @return
     */
    @Select("SELECT * FROM t_article_tag WHERE article_id=#{articleId} ")
    List<ArticleTag> selectByArticleId(@Param("articleId")String articleId);
}
