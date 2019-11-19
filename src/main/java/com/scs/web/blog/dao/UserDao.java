package com.scs.web.blog.dao;

import com.scs.web.blog.domain.dto.UserDto;
import com.scs.web.blog.entity.User;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName UserDao
 * @Description UserDao数据访问对象接口
 * @Author qin jian
 * @Date 2019/11/12
 * @Version 1.0
 **/
public interface UserDao {
    /**
     * 批量插入用户信息
     * @param userList
     * @return
     * @throws SQLException
     */
    int[] batchInsert(List<User> userList) throws SQLException;

    /**
     * 新增用户
     * @param userDto
     * @return
     * @throws SQLException
     */
    int insert(UserDto userDto) throws SQLException;

    /**
     * 查询所有用户的信息
     * @return
     * @throws SQLException
     */
    List<User> selectAll() throws SQLException;

    /**
     * 根据手机号查找用户
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
}
