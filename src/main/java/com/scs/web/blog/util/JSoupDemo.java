//package com.scs.web.blog.util;
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
///**
// * @ClassName $(Name)
// * @Description TODO
// * @Author Qin jian
// * @Date 2019/11/7
// * @Version 1.0
// **/
//public class JSoupDemo {
//    public static void main(String[] args) throws Exception{
//        //声明文档变量
//        Document document;
//        //通过JSoup连接目标页面
//        document = Jsoup.connect("https://www.jianshu.com/recommendations/users?utm_source=desktop&utm_medium=index-users").get();
//        //选取所有class为col-xs-8的元素集合
//        Elements divs =  document.getElementsByClass("col-xs-8");
//        System.out.println(divs.size());
//       //duidivs遍历
//        divs.forEach(div-> {
//            //取出class为wrap的节点
//            Element wrapDiv = div.child(0);
//            Element link = wrapDiv.child(0);
//            Elements linkChildren = link.children();
//            System.out.println(linkChildren.get(1).text());
//            System.out.println("https:" + linkChildren.get(0).attr("src"));
//
//
////            Element img = link.child(0);
////            System.out.println("https:"+img.attr("src"));
//        });
//    }
//}
