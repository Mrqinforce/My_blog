package com.scs.web.blog.util;

import com.aliyun.oss.OSSClient;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.UUID;
/**
 * @ClassName $(Name)
 * @Description TODO
 * @Author Qin jian
 * @Date 2019/12/21
 * @Version 1.0
 **/
@Slf4j
public class AliOssUtil {
    public static String upload(File file) {
        String endpoint = "https://oss-cn-beijing.aliyuncs.com";
        String accessKeyId = "LTAI4FvTq2ETAYzY8HNcnU2d";
        String accessKeySecret = "ByKCVtu2NpwCq5m8B10IBC8Kd5W9sz";
        String bucketName = "sillyforce";
        String filePath = "avatar/";
        String fileName = file.getName();
        String newFileName = UUID.randomUUID().toString() + fileName.substring(fileName.indexOf("."));
        // 创建OSSClient实例
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        // 上传文件到指定位置，并使用UUID更名
        ossClient.putObject(bucketName, filePath + newFileName, file);
        // 拼接URL
        String url = "https://sillyforce.oss-cn-beijing.aliyuncs.com/" + filePath + newFileName;
        ossClient.shutdown();
        return url;
    }
}
