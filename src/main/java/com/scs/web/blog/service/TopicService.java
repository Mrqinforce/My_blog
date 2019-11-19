package com.scs.web.blog.service;

import com.scs.web.blog.util.Result;

/**
 * @ClassName TopicService)
 * @Description TODO
 * @Author qin jian
 * @Date 2019/11/18
 * @Version 1.0
 **/
public interface TopicService {
    /**
     * 获取热门专题
     * @param id
     * @return
     */
    Result getHotTopics();

//    /**
//     * 分页查询专题
//     * @param currentPage
//     * @param pageCount
//     * @return
//     */
//    Result getPageTopics(int currentPage,int pageCount);
//
//
//    /**
//     * 根据id获取专题详情
//     * @param id
//     * @return
//     */
//    Result getTopic(long id);
}