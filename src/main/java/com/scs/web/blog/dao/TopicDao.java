package com.scs.web.blog.dao;
import com.scs.web.blog.entity.Topic;

import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName TopicDao
 * @Description TODO
 * @Author qin jian
 * @Date 2019/11/15
 * @Version 1.0
 **/
public interface TopicDao {
        /**
         * 批量新增专题
         *
         * @param topicList
         * @return
         * @throws SQLException
         */
        int[] batchInsert(List<Topic> topicList) throws SQLException;

        /**
         * 获取热门专题
         * @return
         * @throws SQLException
         */
        List<Topic> selectHotTopics() throws SQLException;


    }



