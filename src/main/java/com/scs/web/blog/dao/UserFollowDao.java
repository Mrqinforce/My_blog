package com.scs.web.blog.dao;

import com.scs.web.blog.entity.UserFollow;

import java.sql.SQLException;
/**
 * @ClassName UserFollowDao
 * @Description TODO
 * @Author qin jian
 * @Date 2019/12/23
 * @Version 1.0
 **/
public interface UserFollowDao {
    /**
     * 查询关注
     * @param fromId
     * @param toId
     * @return
     * @throws SQLException
     */
    boolean selectFollow(long fromId, long toId) throws SQLException;

    /**
     * 插入一条关注信息
     * @param userFollow
     * @return
     * @throws SQLException
     */
    boolean insertFollow(UserFollow userFollow) throws SQLException;

    /**
     * 删除关注
     * @param fromId
     * @param toId
     * @return
     * @throws SQLException
     */
    boolean deleeteFollow(long fromId, long toId) throws SQLException;
}
