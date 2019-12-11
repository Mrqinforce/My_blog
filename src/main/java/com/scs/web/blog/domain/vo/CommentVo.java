package com.scs.web.blog.domain.vo;

import com.scs.web.blog.entity.Comment;
import lombok.Data;
import com.scs.web.blog.entity.User;

/**
 * @ClassName CommentVo
 * @Description TODO
 * @Author Qin jian
 * @Date 2019/12/11
 * @Version 1.0
 **/
@Data
public class CommentVo {
    private User author;
    private Comment comment;
}