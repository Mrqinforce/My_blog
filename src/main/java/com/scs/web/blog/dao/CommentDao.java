package com.scs.web.blog.dao;


import com.scs.web.blog.domain.vo.CommentVo;
import com.scs.web.blog.entity.Comment;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName CommentDao
 * @Description TODO
 * @Author qin jian
 * @Date 2019/12/10
 * @Version 1.0
 **/
public interface CommentDao {
    /**
     * 新增评论
     * @param comment
     * @return
     * @throws SQLException
     */
    int insert(Comment comment) throws SQLException;

    /**
     * 根据文章id查出所有评论
     * @param articleId
     * @return
     * @throws SQLException
     */
    List<CommentVo> getCommments(long articleId) throws  SQLException;
}