package com.jh.vlog.service;

import com.jh.vlog.model.entity.Tag;

import java.util.List;

/**
 * @ClassName TagService
 * @Description TODO
 * @Author apple
 * @Date 2020/12/14
 **/
public interface TagService {

    List<Tag> selectAll();
}
