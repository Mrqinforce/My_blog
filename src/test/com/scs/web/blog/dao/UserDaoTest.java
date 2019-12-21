package com.scs.web.blog.dao;

import com.scs.web.blog.entity.User;
import com.scs.web.blog.factory.DaoFactory;
import com.scs.web.blog.util.SpiderUtil;
import org.junit.Test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class UserDaoTest {
    private UserDao userDao = DaoFactory.getUserDaoInstance();

    @Test
    public void insert() throws SQLException {
        User user = new User("13988887777","111");
        userDao.insert(user);
    }

    @Test
    public void batchInsert() throws SQLException {
        userDao.batchInsert(SpiderUtil.getUsers());
    }

    @Test
    public void findUserByMobile() throws SQLException {
        User user = userDao.findUserByMobile("13951905171");
        System.out.println(user);
    }

    @Test
    public void selectHotUsers() throws SQLException {
        List<User> userList = userDao.selectHotUsers();
        userList.forEach(System.out::println);
    }

    @Test
    public void selectByKeywords() throws SQLException{
        List<User> userList = userDao.selectByKeywords("王");
        System.out.println(userList.size());
    }
    @Test
    public void alterUser() {
        User user = new User();
        user.setNickname("qin");
        user.setGender("男");
        LocalDate localDate = LocalDate.parse("2019-12-13", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        user.setBirthday(localDate);
        user.setAddress("地址");
        user.setIntroduction("1293340422");
        user.setEmail("1293340422@qq.com");
        user.setId(23l);
        boolean b = false;
        try {
            b = userDao.alterUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(b);
    }
    @Test
    public void update()throws SQLException {
        User user = userDao.findUserByMobile("12567854674");
        user.setAvatar("111");
        userDao.updateavatar(user);
    }
    @Test
    public void updatearticle() throws SQLException{
        int result = userDao.updatearticle(1l);
        System.out.println(result);
    }
    @Test
    public void updatee() throws SQLException{
        User user = userDao.getUserr(1);
        user.setArticles((user.getArticles()));
        userDao.updatee(user);
    }

}