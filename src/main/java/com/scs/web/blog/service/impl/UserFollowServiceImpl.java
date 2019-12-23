package com.scs.web.blog.service.impl;

import com.scs.web.blog.dao.UserFollowDao;
import com.scs.web.blog.entity.UserFollow;
import com.scs.web.blog.factory.DaoFactory;
import com.scs.web.blog.service.UserFollowService;
import com.scs.web.blog.util.Result;
import com.scs.web.blog.util.ResultCode;

import java.sql.SQLException;
/**
 * @ClassName UserFollowServiceImpl)
 * @Description TODO
 * @Author Qin jian
 * @Date 2019/12/23
 * @Version 1.0
 **/
public class UserFollowServiceImpl implements UserFollowService {
    UserFollowDao userFollowDao = DaoFactory.getUserFollowDaoInstance();

    @Override
    public Result showFollow(long fromId, long toId) {
        boolean b = false;
        try {
            b = userFollowDao.selectFollow(fromId, toId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (b) {
            return Result.success();
        }
        return Result.failure(ResultCode.DATA_IS_WRONG);
    }

    @Override
    public Result follow(UserFollow userFollow) {
        boolean b = false;
        try {
            b = userFollowDao.insertFollow(userFollow);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (b) {
            return Result.success();
        }
        return Result.failure(ResultCode.DATA_IS_WRONG);
    }

    @Override
    public Result cancelFollow(long fromId, long toId) {
        boolean b = false;
        try {
            b = userFollowDao.deleeteFollow(fromId, toId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (b) {
            return Result.success();
        }
        return Result.failure(ResultCode.DATA_IS_WRONG);
    }
}
