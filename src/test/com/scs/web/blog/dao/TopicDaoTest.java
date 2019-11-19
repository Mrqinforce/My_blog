package com.scs.web.blog.dao;
import com.scs.web.blog.factory.DaoFactory;
import com.scs.web.blog.util.JSoupSpider;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.*;
/**
 * @ClassName $(Name)
 * @Description TODO
 * @Author Qin jian
 * @Date 2019/11/18
 * @Version 1.0
 **/
public class TopicDaoTest {
    private TopicDao topicDao = DaoFactory.getTopicDaoInstance();

    @Test
    public void batchInsert() throws SQLException {
        int[] result = topicDao.batchInsert(JSoupSpider.getTopics());
        System.out.println(result.length);
    }
}