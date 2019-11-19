package com.scs.web.blog.domain.dto;
import lombok.Data;

/**
 * @ClassName UserDto
 * @Description 用户传输对象
 * @Author Qin jian
 * @Date 2019/11/12
 * @Version 1.0
 **/
@Data
public class UserDto {
    private String mobile;
    private String password;
    private String nickname;

    public UserDto(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

    public UserDto(String mobile, String password, String nickname) {
        this.mobile = mobile;
        this.password = password;
        this.nickname = nickname;
    }

    public UserDto() {
    }
}
