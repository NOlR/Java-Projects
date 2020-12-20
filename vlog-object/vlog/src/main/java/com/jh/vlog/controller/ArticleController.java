package com.jh.vlog.controller;

import com.github.pagehelper.PageInfo;
import com.jh.vlog.common.ResponseResult;
import com.jh.vlog.model.entity.Article;
import com.jh.vlog.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName ArticleCOntroller
 * @Description TODO
 * @Author apple
 * @Date 2020/12/15
 **/
@RestController
@RequestMapping(value = "/api/article")
@Slf4j
public class ArticleController {
    @Resource
    private ArticleService articleService;

    @PostMapping("page")
    public PageInfo<Article> getArticlesByPage(@RequestParam(name = "pageNum",defaultValue = "1",required = false)int pageNum,
                                            @RequestParam(name = "pageSize",defaultValue = "9",required = false)int pageSize){
        PageInfo<Article> articlePageInfo = articleService.selectByPage(pageNum,pageSize,getUserId());
        if (articlePageInfo == null){
            throw  new NullPointerException();
        }
        return articlePageInfo;
    }


    @GetMapping("recommend")
    public List<Article> getRecommend(){
        List<Article> rocommengArticles = articleService.getRecommendArticles(getUserId());
        if (rocommengArticles==null){
            throw  new NullPointerException();
        }
        return rocommengArticles;
    }

    @GetMapping("{id}")
    public Article getArticleDatail(@PathVariable String id){
        Article detail = articleService.getDetail(id);

    }
    public int getUserId(){
        //通过RequestContextHolder来取得请求的request对象
        RequestAttributes at = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) at;
        assert sra !=null;
        HttpServletRequest request = sra.getRequest();
        //取消请求头
        return Integer.parseInt(request.getHeader("userId"));
    }

    @PostMapping("post")
    public Article postArticle(@RequestBody Article article){
        return articleService.postArticle(article);
    }
}
