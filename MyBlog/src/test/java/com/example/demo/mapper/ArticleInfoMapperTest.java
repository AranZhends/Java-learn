package com.example.demo.mapper;

import com.example.demo.model.ArticleInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class ArticleInfoMapperTest {

    @Resource
    private ArticleInfoMapper articleInfoMapper;

    @Test
    void getAll() {
        List<ArticleInfo> list = articleInfoMapper.getAll();
        list.forEach(System.out::println);
    }

    @Test
    void getArticleInfo() {
        List<ArticleInfo> list = articleInfoMapper.getArticleInfo("Java",null,0);
        list.forEach(System.out::println);
    }

    @Test
    void addArticle() {
        articleInfoMapper.addArticle("今天星期二","今天下雨了",1,0,0);
    }

    @Test
    void getArticleInfo2() {
        List<ArticleInfo> list = articleInfoMapper.getArticleInfo2(null,null,0);
        list.forEach(System.out::println);
    }

    @Test
    void getArticleInfo3() {
        List<ArticleInfo> list = articleInfoMapper.getArticleInfo3(null, null,0);
        list.forEach(System.out::println);
    }

   /* @Test
    void upArticle() {
        int result = articleInfoMapper.upArticle(2,"Spring",null);
        System.out.println(result);
    }*/

    @Test
    void delArticleByIds() {
        int result = articleInfoMapper.delArticleByIds(new int[] {1,2});
        System.out.println(result);
    }
}