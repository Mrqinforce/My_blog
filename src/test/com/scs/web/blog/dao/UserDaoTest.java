package com.scs.web.blog.dao;
import com.scs.web.blog.domain.dto.UserDto;
import com.scs.web.blog.entity.User;
import com.scs.web.blog.factory.DaoFactory;
import com.scs.web.blog.util.JSoupSpider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.SQLException;
/**
 * @ClassName $(Name)
 * @Description TODO
 * @Author Qin jian
 * @Date 2019/11/12
 * @Version 1.0
 **/
public class UserDaoTest {
    private static Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
    private UserDao userDao = DaoFactory.getUserDaoInstance();
    @Test
    public void batchInsert() {
        try {
            int[] result = userDao.batchInsert(JSoupSpider.getUsers());
            if(result.length !=0){
                logger.info("成功新增"+result.length+"个用户");
            }
        } catch (SQLException e) {
            logger.error("批量新增用户出现异常");
        }
    }
    @Test
    public void insert(){
        try {
            UserDto userDto = new UserDto();
            userDto.setMobile("13739173619");
            userDto.setPassword("11111111");
            userDto.setNickname("qj");
            int result = userDao.insert(userDto);
            if (result == 1) {
                logger.info("成功新增一名用户！");
            }
        } catch (SQLException e) {
            logger.error("新增一名用户失败！");
        }
    }
}

