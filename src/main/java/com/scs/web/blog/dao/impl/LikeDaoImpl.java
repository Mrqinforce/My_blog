package com.scs.web.blog.dao.impl;
import com.scs.web.blog.dao.LikeDao;
import com.scs.web.blog.entity.Like;
import com.scs.web.blog.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @ClassName LikeDaoImpl
 * @Description TODO
 * @Author Qin jian
 * @Date 2019/12/18
 * @Version 1.0
 **/
public class LikeDaoImpl implements LikeDao {

    @Override
    public boolean selectIfLikes(long useId, long articleId) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT * FROM t_like WHERE user_id=? AND article_id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, useId);
        pstmt.setLong(2, articleId);
        ResultSet rs = pstmt.executeQuery();
        if ( rs.next()){
            return true;
        } else {
            return false;
        }

    }

    @Override
    public boolean insertLike(Like like) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "INSERT INTO t_like (user_id, article_id) VALUES (?, ?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, like.getUserId());
        pstmt.setLong(2, like.getArticleId());
        int n = pstmt.executeUpdate();
        DbUtil.close(connection, pstmt);
        if (n == 1){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public long selectLikes(long articleId) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "SELECT likes FROM t_article WHERE id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, articleId);
        ResultSet rs = pstmt.executeQuery();
        long likes = 0;
        while (rs.next()) {
            likes = rs.getLong("likes");
        }
        return likes;
    }

    @Override
    public boolean alterLikes(long articleId) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "UPDATE t_article SET likes=? WHERE id=? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, selectLikes(articleId)+1);
        pstmt.setLong(2, articleId);
        int result = pstmt.executeUpdate();
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean deleteLike(long useId, long articleId) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "DELETE FROM t_like WHERE user_id=? AND article_id=?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, useId);
        pstmt.setLong(2, articleId);
        int result = pstmt.executeUpdate();
        if (result > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean cancelLike(long articleId) throws SQLException {
        Connection connection = DbUtil.getConnection();
        String sql = "UPDATE t_article SET likes=? WHERE id=? ";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setLong(1, selectLikes(articleId)-1);
        pstmt.setLong(2, articleId);
        int result = pstmt.executeUpdate();
        if (result == 1) {
            return true;
        } else {
            return false;
        }
    }

}