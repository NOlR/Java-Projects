package com.jh.vlog.service;

import com.jh.vlog.model.entity.Comment;
import com.jh.vlog.model.vo.CommentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName CommentService
 * @Description TODO
 * @Author apple
 * @Date 2020/12/22
 **/
public interface CommentService {
    /**
     * 根据文章id查询评论
     * @param articleId
     * @return
     */
    List<CommentVo> selectArticleId(String articleId);

    /**
     * 新增评论
     * @param comment
     * @return
     */
    List<CommentVo> addComment(@Param("comment") Comment comment);
}
