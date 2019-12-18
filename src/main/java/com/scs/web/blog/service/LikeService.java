package com.scs.web.blog.service;

import com.scs.web.blog.entity.Like;
import com.scs.web.blog.util.Result;
/**
 * @ClassName LikeService
 * @Description TODO
 * @Author qin jian
 * @Date 2019/12/18
 * @Version 1.0
 **/
public interface LikeService {

    /**
     * 获得喜欢信息
     * @param userId
     * @param articleId
     * @return
     */
    Result getLike(long userId, long articleId);

    /**
     * 喜欢数加一
     * @param like
     * @return
     */
    Result addLike(Like like);

    /**
     * 取消喜欢
     * @param userId
     * @param articleId
     * @return
     */
    Result lessenLike(long userId, long articleId);
}
