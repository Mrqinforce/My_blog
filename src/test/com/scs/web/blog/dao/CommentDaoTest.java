package com.scs.web.blog.dao;

import com.scs.web.blog.entity.Comment;
import com.scs.web.blog.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * @ClassNameCommentDaotest
 * @Description TODO
 * @Author Qin jian
 * @Date 2019/12/10
 * @Version 1.0
 **/
public class CommentDaoTest {

    private CommentDao commentDao = DaoFactory.getCommentDaoInstance();
    @Test
    public void insert() {
        int n = 0;
        Comment comment = new Comment();
        comment.setUserId(11);
        comment.setArticleId(31);
        comment.setContent("nonono");
        comment.setCreateTime(LocalDateTime.now());
        try {
            n = commentDao.insert(comment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(n);
    }
    @Test
    public void delete() throws SQLException{
        int result = commentDao.delete((long) 12);
    }
}