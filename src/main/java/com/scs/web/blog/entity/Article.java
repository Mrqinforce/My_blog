package com.scs.web.blog.entity;

import lombok.Data;

import java.time.LocalDateTime;
/**
 * @ClassName Artilce
 * @Description 图书实体类
 * @Author Qin jian
 * @Date 2019/11/12
 * @Version 1.0
 **/
@Data
public class Article {
    private Long id;
    private Long userId;
    private String title;
    private String content;
    private String cover;
    private Integer diamond;
    private Integer comments;
    private Integer likes;
    private LocalDateTime publishTime;
}