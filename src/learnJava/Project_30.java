package learnJava;

import java.util.ArrayList;
import java.util.Collection;

/*
 * Collection接口中的基本常用方法
 */
public class Project_30 {
    public static void main(String[] args) {
        Collection<String> c = new ArrayList<>();


        System.out.println(c.size());  //返回集合中有多少元素
        System.out.println(c.isEmpty());  //判断是否为空
        c.add("第一个泛型元素");   //加入
        c.add("第二个泛型元素");
        System.out.println(c.contains("第一个泛型元素"));  //判断是否包含某一元素
        Object[] obj = c.toArray();  //转为对象数组
        c.remove("第一个泛型元素"); //移除，不是delete删除（删地址，不是删对象）
        c.clear();  //移出所有的元素


    }
}
