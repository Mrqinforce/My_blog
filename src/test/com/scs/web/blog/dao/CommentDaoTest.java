package com.scs.web.blog.dao;

import com.scs.web.blog.domain.dto.CommentDto;
import com.scs.web.blog.factory.DaoFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

/**
 * @ClassNameCommentDaotest
 * @Description TODO
 * @Author Qin jian
 * @Date 2019/12/10
 * @Version 1.0
 **/
public class CommentDaoTest {
    private  static Logger logger = LoggerFactory.getLogger(CommentDaoTest.class);
    private CommentDao commentDao = DaoFactory.getCommentDaoInstance();
    @Test
    public void insert() throws SQLException {
        CommentDto commentDto = new CommentDto();
        commentDto.setNickname("jian");
        commentDto.setContent("yes");
        int result = commentDao.insert(commentDto);
        if(result == 1) {
            logger.info("成功");
        }else {
            logger.error("失败");
        }
    }
}