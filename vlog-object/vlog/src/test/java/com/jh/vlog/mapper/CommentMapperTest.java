package com.jh.vlog.mapper;

import com.jh.vlog.VlogApplication;
import com.jh.vlog.model.entity.Comment;
import com.jh.vlog.model.vo.CommentVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = VlogApplication.class)
@Slf4j
class CommentMapperTest {
    @Resource
    private CommentMapper commentMapper;

    @Test
    void selectByArticleId() {
        List<CommentVo> commentVos = commentMapper.selectByArticleId("01f7dc9173ef47bd8e11d91c6661bb68");
        commentVos.forEach(commentVo -> System.out.println(commentVo));
    }

    @Test
    void addComment() {
        Comment comment = Comment.builder()
                .articleId("01f7dc9173ef47bd8e11d91c6661bb68")
                .userId(1)
                .content("测试评论")
                .createTime(LocalDateTime.now())
                .build();
        commentMapper.addComment(comment);
    }
}