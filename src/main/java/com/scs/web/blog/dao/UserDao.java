package com.scs.web.blog.dao;

import com.scs.web.blog.domain.vo.UserVo;
import com.scs.web.blog.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @author mq_xu
 * @ClassName UserDao
 * @Description UserDao数据访问对象接口
 * @Date 2019/11/9
 * @Version 1.0
 **/
public interface UserDao {
    /**
     * 新增用户
     *
     * @param user
     * @throws SQLException
     */
    void insert(User user) throws SQLException;

    /**
     * 批量新增用户
     *
     * @param userList
     * @throws SQLException
     */
    void batchInsert(List<User> userList) throws SQLException;

    /**
     * 根据手机号查找用户
     *
     * @param mobile
     * @return
     * @throws SQLException
     */
    User findUserByMobile(String mobile) throws SQLException;

    /**
     * 查询热门用户
     *
     * @return
     * @throws SQLException
     */
    List<User> selectHotUsers() throws SQLException;


    /**
     * 查询分页用户
     * @param currentPage
     * @param count
     * @return
     * @throws SQLException
     */
    List<User> selectByPage(int currentPage, int count) throws SQLException;

    /**
     * 根据id查询用户
     * @param  id
     * @return
     * @throws SQLException
     */
    UserVo getUser(long id) throws SQLException;


    /**
     * 模糊搜索用户
     * @param keywords
     * @return
     * @throws SQLException
     */
    List<User> selectByKeywords(String keywords) throws SQLException;
    /**
     * 修改用户信息·
     * @param user
     * @return
     * @throws SQLException
     */
    boolean alterUser(User user) throws SQLException;
    /**
     *修改用户头像
     * @param user
     * @throws SQLException
     */
    void updateavatar(User user) throws SQLException;

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    int updatearticle(long id) throws SQLException;
    /**
     * 根据id获取user数据
     * @param id
     * @return
     * @throws SQLException
     */
    User getUserr(long id) throws SQLException;
    /**
     * 更新文章数
     * @param user
     * @return
     * @throws SQLException
     */
    int updatee(User user) throws SQLException;
}