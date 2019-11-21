package com.scs.web.blog.util;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Random;
/**
 * @ClassName StringUtil
 * @Description 字符串工具类
 * @Author Qin jian
 * @Date 2019/11/15
 * @Version 1.0
 **/
public class StringUtil {
    /**
     * 提取字符串中的数字字符为一个字符串数组
     *
     * @param sourceStr
     * @return
     */
    public static String[] getDigital(String sourceStr) {
        String[] result = new String[sourceStr.length()];
        //这个2是指连续数字的最少个数
        Pattern p = Pattern.compile("\\d{2,}");
        Matcher m = p.matcher(sourceStr);
        int i = 0;
        while (m.find()) {
            result[i] = m.group();
            i++;
        }
        return result;
    }
        //    public static void main(String[] args) {
//        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//        StringBuilder sb=new StringBuilder(6);
//        for(int i=0;i<6;i++)
//        {
//            char ch=str.charAt(new Random().nextInt(str.length()));
//            sb.append(ch);
//        }
//        System.out.println(sb.toString());
//
//
//    }
//    public static void main(String[] args) {
//        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//        StringBuilder sb=new StringBuilder(4);
//        for(int i=0;i<4;i++)
//        {
//            char ch=str.charAt(new Random().nextInt(str.length()));
//            sb.append(ch);
//        }
//        System.out.println(sb.toString());
//
//
//
//        //随机生成六位数字
//        System.out.println((int)((Math.random()*9+1)*100000));
//        //随机生成五位数字
//        System.out.println((int)((Math.random()*9+1)*10000));
//
//
//    }
//
        public static String getRandomString(int length) {
            Random random = new Random();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < length; i++) {
                int number = random.nextInt(3);
                long result = 0;
                switch (number) {
                    case 0:
                        result = Math.round(Math.random() * 25 + 65);
                        sb.append(String.valueOf((char) result));
                        break;
                    case 1:
                        result = Math.round(Math.random() * 25 + 97);
                        sb.append(String.valueOf((char) result));
                        break;
                    case 2:
                        sb.append(String.valueOf(new Random().nextInt(10)));
                        break;
                }

            }
            return sb.toString();
        }

        public static void main(String[] args) {
            System.out.println(StringUtil.getRandomString(6));
            Pattern p = Pattern.compile("\\d{2,}");//这个2是指连续数字的最少个数
            String u = "收录了 27093 篇文章，35936 人关注";
            Matcher m = p.matcher(u);
            int i = 0;
            while (m.find()) {
                System.out.println(m.group());
                i++;
            }
        }

    }
