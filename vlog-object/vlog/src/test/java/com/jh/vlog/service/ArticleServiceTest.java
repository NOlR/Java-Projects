package com.jh.vlog.service;

import com.github.pagehelper.PageInfo;
import com.jh.vlog.VlogApplication;
import com.jh.vlog.model.entity.Article;
import com.jh.vlog.task.ArticleTask;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = VlogApplication.class)
@Slf4j
class ArticleServiceTest {
    @Resource
    private ArticleService articleService;
    @Resource
    private ArticleTask articleTask;

    @Test
    void insertArticles() {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 8, 5,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        Future<List<Article>> future = executor.submit(articleTask);
        List<Article> articles = null;
        try {
            articles = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        articleService.insertArticles(articles);
    }

//    @Test
//    void selectAll() {
//        List<Article> articles = articleService.selectAll();
//        System.out.println(articles);
//    }

    @Test
    void selectByPage() {
        PageInfo<Article> articlePageInfo = articleService.selectByPage(1,9,1);
        System.out.println(articlePageInfo.getList().size());
    }

    @Test
    void getRecommendArticles() {
        List<Article> recommendArticles =articleService.getRecommendArticles(1);
        recommendArticles.forEach(System.out::println);
    }

    @Test
    void getDetail() {
        Article detail = articleService.getDetail("008f5a80-db3f-41a5-afe0-327032aec51a");
        System.out.println(detail);
    }
}