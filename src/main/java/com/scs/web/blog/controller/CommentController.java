package com.scs.web.blog.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.scs.web.blog.entity.Comment;
import com.scs.web.blog.factory.ServiceFactory;
import com.scs.web.blog.service.CommentService;
import com.scs.web.blog.util.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @ClassName CommentController
 * @Description TODO
 * @Author Qin jian
 * @Date 2019/12/10
 * @Version 1.0
 **/
@WebServlet(urlPatterns = {"/api/comment","/api/comments/delete/*"})
public class CommentController extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(CommentController.class);
    private CommentService commentService = ServiceFactory.getCommentServiceInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Gson gson = new GsonBuilder().create();
        String id = req.getParameter("articleId");
        Result result = commentService.showComment(Long.valueOf(id));
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(result));
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        Gson gson = new GsonBuilder().create();
        Comment comment = gson.fromJson(stringBuilder.toString(), Comment.class);
        Result result = commentService.writeComment(comment);
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(result));
        out.close();
    }
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI().trim();
        System.out.println(uri);
        if(uri.contains("/api/comments/delete"))
            deleteComment(req, resp);
    }

    private void deleteComment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String info = req.getPathInfo().trim();
        String id = info.substring(info.indexOf("/") + 1);
//        String id = req.getParameter("id");
        Result result = commentService.deleteComment(Long.parseLong(id));
        Gson gson = new GsonBuilder().create();
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(result));
        out.close();
    }


}