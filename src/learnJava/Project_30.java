package learnJava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * Collection接口中的基本常用方法
 */
public class Project_30 {
    public static void main(String[] args) {
        test01();
        test02();
    }

    public static void test01() {
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

    public static void test02(){
        List<String> list01 = new ArrayList<>();
        list01.add("aa");
        list01.add("bb");
        list01.add("cc");

        List<String> list02 = new ArrayList<>();
        list02.add("aa");
        list02.add("dd");
        list02.add("ee");

        System.out.println("list01:" + list01);

        list01.addAll(list02);   //添加至集合中
        System.out.println("list01:" + list01);

        System.out.println(list01.containsAll(list02)); //该集合是否包含后面的集合

        list01.removeAll(list02);   //删除两集合中相同的元素
        System.out.println("list01:" + list01);

        list01.retainAll(list02);//  取交集
        System.out.println("list01:" + list01);


    }
}
