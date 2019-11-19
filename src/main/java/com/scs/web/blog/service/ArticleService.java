package com.scs.web.blog.service;

import com.scs.web.blog.domain.vo.ArticleVo;
import com.scs.web.blog.entity.Article;

import java.util.List;
/**
 * @ClassName ArticleService
 * @Description TODO
 * @Author qin jian
 * @Date 2019/11/15
 * @Version 1.0
 **/
public interface ArticleService {
//    /**
//     * 获取热门文章
//     *
//     * @return
//     */
//    Result getHotArticles();
//
//    /**
//     * 获取分页文章
//     *
//     * @return
//     */
//    Result getPageArticles(int currentPage, int pageCount);
//
//    /**
//     * 获取文章详情
//     *
//     * @return
//     */
//    Result getArticle(long id);
    /**
     * 获取热门文章
     * @return
     */
    List<ArticleVo> getHotArticles();
}
