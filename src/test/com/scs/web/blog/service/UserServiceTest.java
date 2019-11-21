package com.scs.web.blog.service;


import com.scs.web.blog.domain.dto.UserDto;
import com.scs.web.blog.factory.ServiceFactory;
import org.junit.Test;

import java.util.Map;
/**
 * @ClassName $(Name)
 * @Description TODO
 * @Author Qin jian
 * @Date 2019/11/12
 * @Version 1.0
 **/
public class UserServiceTest {
    private UserService userService = ServiceFactory.getUserServiceInstance();
    @Test
    public void signIn() {
        UserDto userDao = new UserDto("13989412100","5fc4967fe0a33825e951baf3881c3f39");
        Map<String,Object> map = userService.signIn(userDao);
        map = userService.signIn(userDao);
        System.out.println(map.get("msg"));
        System.out.println(map.get("data"));
    }
}