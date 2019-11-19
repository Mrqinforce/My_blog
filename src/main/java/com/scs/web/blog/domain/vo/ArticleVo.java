package com.scs.web.blog.domain.vo;

import lombok.Data;

import lombok.Data;
/**
 * @ClassName ArticleVo
 * @Description 文章视图类,从文章、专题、用户表联查出前端需要展示的数据
 * @Author Qin jian
 * @Date 2019/11/15
 * @Version 1.0
 **/
@Data
public class ArticleVo {
    private Long id;
    private Long userId;
    private String nickname;
    private String avatar;
    private String title;
    private String content;
    private String diamond;
    private Integer likes;
    private Integer comments;
}
