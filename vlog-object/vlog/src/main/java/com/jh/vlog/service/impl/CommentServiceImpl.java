package com.jh.vlog.service.impl;

import com.jh.vlog.mapper.CommentMapper;
import com.jh.vlog.model.entity.Comment;
import com.jh.vlog.model.vo.CommentVo;
import com.jh.vlog.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @ClassName CommentServiceImpl
 * @Description TODO
 * @Author apple
 * @Date 2020/12/22
 **/
@Service
public class CommentServiceImpl implements CommentService {
    @Resource
    private CommentMapper commentMapper;
    @Override
    public List<CommentVo> selectArticleId(String articleId) {
        return commentMapper.selectByArticleId(articleId);
    }

    @Override
    public List<CommentVo> addComment(Comment comment) {
        //补充评论时间
        comment.setCreateTime(LocalDateTime.now());
        //插入
        commentMapper.addComment(comment);
        //查处这篇文章最新的评论列表
        return  commentMapper.selectByArticleId(comment.getArticleId());
    }
}
