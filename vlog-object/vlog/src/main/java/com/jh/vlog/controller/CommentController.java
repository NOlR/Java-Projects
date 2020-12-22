package com.jh.vlog.controller;

import com.jh.vlog.common.ResultCode;
import com.jh.vlog.exception.Customexception;
import com.jh.vlog.model.entity.Comment;
import com.jh.vlog.model.vo.CommentVo;
import com.jh.vlog.service.CommentService;
import jdk.internal.util.xml.impl.ReaderUTF8;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.transform.Result;
import java.util.List;

/**
 * @ClassName CommentController
 * @Description TODO
 * @Author apple
 * @Date 2020/12/22
 **/
@RestController
@RequestMapping(value = "/api/comment")
@Slf4j
public class CommentController {
    @Resource
    private CommentService commentService;
    @GetMapping("{articleId}")
    public List<CommentVo> selectByArticleId(@PathVariable String articleId) {
        List<CommentVo> commentVos = commentService.selectArticleId(articleId);
        log.info(String.valueOf(commentVos));
        //如果查找结果size为0，抛出"出局未找到"的自定义异常
        if (commentVos.size() == 0) {
            throw new Customexception(ResultCode.RESULT_CODE_DATA_NONE.message(), ResultCode.RESULT_CODE_DATA_NONE);
        }
        return commentVos;
    }

    @PostMapping("add")
    public List<CommentVo> addComment(@RequestBody Comment comment){
        log.info(String.valueOf(comment));
        List<CommentVo> commentVos = commentService.addComment(comment);
        if (comment == null){
            throw new Customexception(ResultCode.DATA_IS_WRONG.message(), ResultCode.DATA_IS_WRONG);
        }
        return commentVos;
    }
}
