package com.scs.web.blog.service.impl;

import com.scs.web.blog.dao.ArticleDao;
import com.scs.web.blog.dao.UserDao;
import com.scs.web.blog.domain.vo.ArticleVo;
import com.scs.web.blog.entity.Article;
import com.scs.web.blog.entity.User;
import com.scs.web.blog.factory.DaoFactory;
import com.scs.web.blog.service.ArticleService;
import com.scs.web.blog.util.Result;
import com.scs.web.blog.util.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;
import java.util.List;

/**
 * @author mq_xu
 * @ClassName ArticleServiceImpl
 * @Description TODO
 * @Date 22:49 2019/11/11
 * @Version 1.0
 **/
public class ArticleServiceImpl implements ArticleService {
    private ArticleDao articleDao = DaoFactory.getArticleDaoInstance();
    private static Logger logger = LoggerFactory.getLogger(ArticleServiceImpl.class);
    private UserDao userDao = DaoFactory.getUserDaoInstance();



    @Override
    public Result getHotArticles() {
        List<ArticleVo> articleVoList = null;
        try {
            articleVoList = articleDao.selectHotArticles();
        } catch (SQLException e) {
            logger.error("查询热门文章出现异常");
        }
        if (articleVoList != null) {
            return Result.success(articleVoList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result getArticlesByPage(int currentPage, int count) {
        List<ArticleVo> articleVoList = null;
        try {
            articleVoList = articleDao.selectByPage(currentPage, count);
        } catch (SQLException e) {
            logger.error("分页查询文章出现异常");
        }
        if (articleVoList != null) {
            return Result.success(articleVoList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result getArticle(long id) {
        ArticleVo articleVo = null;
        try {
            articleVo = articleDao.getArticle(id);
        } catch (SQLException e) {
            logger.error("根据id查询文章出现异常");
        }
        if (articleVo != null) {
            return Result.success(articleVo);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result selectByKeywords(String keywords) {
        List<ArticleVo> articleVoList = null;
        try {
            articleVoList = articleDao.selectByKeywords(keywords);
        } catch (SQLException e) {
            logger.error("根据关键字查询文章出现异常");
        }
        if (articleVoList != null) {
            return Result.success(articleVoList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result writeArticle(Article article) {
        boolean b = false;
        try {
            b = articleDao.insert(article);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (b) {
            return Result.success();
        }
        return Result.failure(ResultCode.DATA_IS_WRONG);

    }

    @Override
    public Result deleteArticle(long id,long userId) {
        int n = 0;
        try {
            n = articleDao.delete(id);
            User user = userDao.getUserr(userId);
            user.setArticles((Integer) (user.getArticles()-1));
            userDao.updatee(user);
        } catch (SQLException e) {
            logger.error("删除异常");
        }
        if( n != 0){
            return Result.success(n);
        }else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }
}