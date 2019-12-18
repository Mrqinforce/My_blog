package com.scs.web.blog.dao;


import com.scs.web.blog.factory.DaoFactory;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * @ClassName $(Name)
 * @Description TODO
 * @Author Qin jian
 * @Date 2019/12/18
 * @Version 1.0
 **/
public class LikeDaoTest {
    private  LikeDao likeDao = DaoFactory.getLikeDaoInstance();

    @Test
    public void selectIfLikes() {

        boolean a= false;
        try {
            a = likeDao.selectIfLikes(7, 2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(a);

    }

    @Test
    public void addOne() {
        try {
            likeDao.alterLikes(2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//    @Test
//    public void deleteOne() {
//        try {
//            likeDao.deleteLike(9,2);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
@Test
public void cancelOne() {
    try {
        likeDao.cancelLike(2);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
}
