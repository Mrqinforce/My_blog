package com.scs.web.blog.service;

import com.scs.web.blog.entity.Article;
import com.scs.web.blog.util.Result;

/**
 * @author mq_xu
 * @ClassName ArticleService
 * @Description 文章服务层接口
 * @Date 2019/11/11
 * @Version 1.0
 **/
public interface ArticleService {
    /**
     * 获取热门文章
     *
     * @return
     */
    Result getHotArticles();

    /**
     * 获取分页文章
     *
     * @param currentPage
     * @param count
     * @return
     */
    Result getArticlesByPage(int currentPage, int count);

    /**
     * 获取文章详情
     *
     * @param id
     * @return
     */
    Result getArticle(long id);


    /**
     * 根据标题或摘要模糊查询文章
     *
     * @param keywords
     * @return
     */
    Result selectByKeywords(String keywords);

    /**
     * 写文章
     * @param article
     * @return
     */
    Result writeArticle(Article article);
    /**
     *删除文章
     * @param id
     * @return
     */
    Result deleteArticle(long id,long userId);
}
