package com.jh.vlog.service;

import com.jh.vlog.VlogApplication;
import com.jh.vlog.model.entity.Comment;
import com.jh.vlog.model.vo.CommentVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.List;
@SpringBootTest(classes = VlogApplication.class)
@Slf4j
class CommentServiceTest {
    @Resource
    private CommentService commentService;

    @Test
    void selectArticleId() {
        List<CommentVo> commentVos = commentService.selectArticleId("01f7dc9173ef47bd8e11d91c6661bb68");
        commentVos.forEach(System.out::println);
    }

    @Test
    void addComment() {
        Comment comment = Comment.builder()
                .articleId("01f7dc9173ef47bd8e11d91c6661bb68")
                .userId(1)
                .content("测试内容2")
                .createTime(LocalDateTime.now())
                .build();
       List<CommentVo> commentVos =  commentService.addComment(comment);
       commentVos.forEach(System.out::println);
    }
}