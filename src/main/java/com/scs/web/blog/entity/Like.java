package com.scs.web.blog.entity;

import lombok.Data;

/**
 * @ClassName $(Name)
 * @Description TODO
 * @Author Qin jian
 * @Date 2019/12/18
 * @Version 1.0
 **/
@Data
public class Like {
    private long id;
    private long userId;
    private long articleId;
}
