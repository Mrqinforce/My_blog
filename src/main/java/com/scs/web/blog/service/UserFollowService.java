package com.scs.web.blog.service;

import com.scs.web.blog.entity.UserFollow;
import com.scs.web.blog.util.Result;
/**
 * @ClassName UserFollowService
 * @Description TODO
 * @Author Qin jian
 * @Date 2019/12/23
 * @Version 1.0
 **/
public interface UserFollowService {

    /**
     * 查
     * @param fromId
     * @param toId
     * @return
     */
    Result showFollow(long fromId, long toId) ;

    /**
     * 关注
     * @param userFollow
     * @return
     */
    Result follow(UserFollow userFollow);

    /**
     * 取消关注
     * @param fromId
     * @param toId
     * @return
     */
    Result cancelFollow(long fromId, long toId);
}
