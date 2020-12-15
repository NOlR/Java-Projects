package com.jh.vlog.controller;

import com.jh.vlog.common.ResponseResult;
import com.jh.vlog.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName TagController
 * @Description TODO
 * @Author apple
 * @Date 2020/12/14
 **/
@RestController
@RequestMapping(value = "/api/tag")
@Slf4j
public class TagController {
    @Resource
    private TagService tagService;
    @GetMapping("all")
    public ResponseResult getTag(){
        return ResponseResult.success(tagService.selectAll());
    }
}
