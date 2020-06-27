package learnJava;

import java.util.ArrayList;
import java.util.List;

/*
 * List  有序，可重复
 *     ArrayList         LinkedList             vector
 *  数组，不安全       双向链表，不安全     数组，线程安全
 *
 */
public class Project_31 {
    public static void main(String[] args) {
        testArrayList();
    }


    public static void testArrayList() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println(list);

        list.add(2, "插入"); //按索引值插入
        System.out.println(list);

        list.remove(1); //按索引值移除
        System.out.println(list);

        list.set(0, "直接修改"); //直接修改指定位置元素
        System.out.println(list);

        System.out.println(list.get(0)); //获得索引位置的元素
        System.out.println(list.indexOf("3")); //返回第一次出现的索引(未找到返回-1)
        System.out.println(list.lastIndexOf("1"));  //返回最后一次一次出现的索引(未找到返回-1)
    }
}
