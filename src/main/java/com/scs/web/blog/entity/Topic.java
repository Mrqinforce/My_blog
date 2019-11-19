package com.scs.web.blog.entity;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @ClassName $(Name)
 * @Description TODO
 * @Author Qin jian
 * @Date 2019/11/15
 * @Version 1.0
 **/
@Data
public class Topic {
    private Long id;
    //管理员id
    private Long adminId;
   private String name;
    private String logo;
    private String description;
    private Integer articles;
    private Integer follows;
    private LocalDateTime createTime;
}