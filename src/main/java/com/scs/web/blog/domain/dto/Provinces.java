package com.scs.web.blog.domain.dto;
import lombok.Data;

import java.util.List;
/**
 * @ClassName ProvinceList
 * @Description 省份集合，包含了全国所有省市数据
 * @Author Qin jian
 * @Date 2019/11/15
 * @Version 1.0
 **/
@Data
public class Provinces {
    private List<Province> provincea;
}
