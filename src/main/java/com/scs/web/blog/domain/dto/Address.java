package com.scs.web.blog.domain.dto;
import lombok.Data;
/**
 * @ClassName Address
 * @Description 地址类，由省和市组成
 * @Author Qin jian
 * @Date 2019/11/15
 * @Version 1.0
 **/
@Data
public class Address {
    private String province;
    private String city;
}