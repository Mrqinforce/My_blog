package com.scs.web.blog.service;

import com.scs.web.blog.entity.Comment;
import com.scs.web.blog.util.Result;


/**
 * @ClassName CommentService
 * @Description TODO
 * @Author qin jian
 * @Date 2019/12/10
 * @Version 1.0
 **/
public interface CommentService {
    /**
     * 写评论
     * @param comment
     * @return
     */
    Result writeComment(Comment comment);

    /**
     * 查看文章所有评论
     * @param articleId
     * @return
     */
    Result showComment(long articleId);
}