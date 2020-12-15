package com.jh.vlog.mapper;

import com.jh.vlog.VlogApplication;
import com.jh.vlog.task.TagTask;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

import com.jh.vlog.model.entity.Tag;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(classes = VlogApplication.class)
class TagMapperTest {
    @Resource
    private TagTask tagTask;
    @Resource
    private TagMapper tagMapper;

    @Test
    void batchInsert() throws ExecutionException, InterruptedException {
        //线程池核心线程为6,最大线程数为10,超时间为5秒
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 8, 5, TimeUnit.SECONDS, new SynchronousQueue<>());
        Future<List<Tag>> future = executor.submit(tagTask);
        List<Tag> tags = future.get();
        int count =tagMapper.insertTags(tags);
        System.out.println(count);
    }

    @Test
    void testSelectAll() {
        List<Tag> tags = tagMapper.selectAll();
        tags.forEach(tag->System.out.println(tag.getTagName()+","+tag.getTagColor()));
    }
}