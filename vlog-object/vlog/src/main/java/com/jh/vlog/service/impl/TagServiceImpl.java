package com.jh.vlog.service.impl;

import com.jh.vlog.mapper.TagMapper;
import com.jh.vlog.model.entity.Tag;
import com.jh.vlog.service.TagService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName TagServiceImpl
 * @Description TODO
 * @Author apple
 * @Date 2020/12/14
 **/
@Service
public class TagServiceImpl implements TagService {
    @Resource
    private TagMapper tagMapper;

    @Override
    public List<Tag> selectAll() {
        return tagMapper.selectAll();
    }



}
