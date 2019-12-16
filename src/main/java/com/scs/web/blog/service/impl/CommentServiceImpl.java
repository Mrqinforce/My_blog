package com.scs.web.blog.service.impl;


import com.scs.web.blog.dao.CommentDao;
import com.scs.web.blog.domain.vo.CommentVo;
import com.scs.web.blog.entity.Comment;
import com.scs.web.blog.factory.DaoFactory;
import com.scs.web.blog.service.CommentService;
import com.scs.web.blog.util.Result;
import com.scs.web.blog.util.ResultCode;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 * @ClassName CommentService
 * @Description TODO
 * @Author Qin jian
 * @Date 2019/12/10
 * @Version 1.0
 **/

public class CommentServiceImpl implements CommentService {
    private  CommentDao commentDao = DaoFactory.getCommentDaoInstance();
    @Override
    public Result writeComment(Comment comment) {
        int n = 0;
        try {
            n = commentDao.insert(comment);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (n==1) {
            return Result.success();
        } else {
            return Result.failure(ResultCode.DATA_IS_WRONG);
        }
    }

    @Override
    public Result showComment(long articleId) {
        List<CommentVo> commentVoList = new ArrayList<>();
        try {
            commentVoList = commentDao.getCommments(articleId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (commentVoList != null) {
            return Result.success(commentVoList);
        } else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }

    @Override
    public Result deleteComment(long id) {
        int n =0;
        try {
            n = commentDao.delete(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(n !=0){
            return  Result.success(n);
        }else {
            return Result.failure(ResultCode.RESULT_CODE_DATA_NONE);
        }
    }
}