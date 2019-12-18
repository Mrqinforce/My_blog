package com.scs.web.blog.service.impl;


import com.scs.web.blog.dao.LikeDao;
import com.scs.web.blog.entity.Like;
import com.scs.web.blog.factory.DaoFactory;
import com.scs.web.blog.service.LikeService;
import com.scs.web.blog.util.Result;
import com.scs.web.blog.util.ResultCode;

import java.sql.SQLException;
/**
 * @ClassName $(Name)
 * @Description TODO
 * @Author Qin jian
 * @Date 2019/12/18
 * @Version 1.0
 **/
public class LikeServiceImpl implements LikeService {
    private LikeDao likeDao = DaoFactory.getLikeDaoInstance();

    /**
     * 查到返回成功， 没查到返回数据未找到
     * @param userId
     * @param articleId
     * @return
     */
    @Override
    public Result getLike(long userId, long articleId) {
        boolean b = false;
        try {
            b = likeDao.selectIfLikes(userId, articleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (b) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result addLike(Like like) {
        boolean a = false;
        boolean b = false;
        try {
            a = likeDao.insertLike(like);
            b = likeDao.alterLikes(like.getArticleId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (a && b) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result lessenLike(long userId, long articleId) {
        boolean a = false;
        boolean b = false;
        try {
            a = likeDao.deleteLike(userId, articleId);
            b = likeDao.cancelLike(articleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (a && b) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }
}
