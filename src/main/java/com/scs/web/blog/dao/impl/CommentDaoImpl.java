package com.scs.web.blog.dao.impl;

import com.scs.web.blog.dao.CommentDao;
import com.scs.web.blog.domain.vo.CommentVo;
import com.scs.web.blog.entity.Article;
import com.scs.web.blog.entity.Comment;
import com.scs.web.blog.entity.User;
import com.scs.web.blog.util.DbUtil;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 * @ClassName CommentDaoImpl
 * @Description TODO
 * @Author Qin jian
 * @Date 2019/12/10
 * @Version 1.0
 **/
public class CommentDaoImpl implements CommentDao {
    @Override
    public int insert(Comment comment) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "INSERT INTO t_comment (user_id, article_id, content, create_time) VALUES (?,?,?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, comment.getUserId());
        pstmt.setLong(2, comment.getArticleId());
        pstmt.setString(3, comment.getContent());
        pstmt.setObject(4, Timestamp.valueOf(LocalDateTime.now()));
        int n = pstmt.executeUpdate();
        DbUtil.close(connection, pstmt);
        return n;
    }

    @Override
    public List<CommentVo> getCommments(long articleId) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT a.*,b.avatar,b.nickname FROM t_comment a LEFT JOIN t_user b ON a.user_id = b.id WHERE a.article_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1, articleId);
        ResultSet resultSet = preparedStatement.executeQuery();

        CommentVo commentVo = null;
        List<CommentVo> commentVoList = new ArrayList<>();
        while (resultSet.next()) {
            Comment  comment = new Comment();
            comment.setId(resultSet.getLong("id"));
            comment.setArticleId(resultSet.getLong("article_id"));
            comment.setUserId(resultSet.getLong("user_id"));
            comment.setContent(resultSet.getString("content"));
            comment.setCreateTime(resultSet.getTimestamp("create_time").toLocalDateTime());
            //写这篇评论的作者的基本信息
            User author = new User();
            author.setNickname(resultSet.getString("nickname"));
            author.setAvatar(resultSet.getString("avatar"));

            commentVo = new CommentVo();
            commentVo.setAuthor(author);
            commentVo.setComment(comment);
            commentVoList.add(commentVo);
        }
        DbUtil.close(connection, preparedStatement, resultSet);
        return commentVoList;
    }

    @Override
    public int delete(long id) throws SQLException { Connection connection = DbUtil.getConnection();
        String sql = "DELETE FROM t_comment WHERE id = ? ";
        PreparedStatement pst = connection.prepareStatement(sql);
        pst.setLong(1,id);
        int i = pst.executeUpdate();
        System.out.println("行数为:" + i);
        return i;
    }
}
