package com.scs.web.blog.entity;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * @ClassName Comment
 * @Description TODO
 * @Author mq_xu
 * @Date 2019/11/29
 **/
@Data
public class Comment {
    private long id;
    private long userId;
    private long articleId;
    private String content;
    private LocalDateTime createTime;

}