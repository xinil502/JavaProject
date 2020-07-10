package learnJava;

/**
 *  Collections工具类
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Project_37 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for(int i=0; i<9; ++i){
            list.add(""+i);
        }
        System.out.println(list);

        Collections.shuffle(list); //随机排列List元素
        System.out.println(list);

        Collections.reverse(list); //逆序排列元素
        System.out.println(list);

        Collections.sort(list);  //按递增排序， 或自定义的Comparable接口
        System.out.println(list);

        System.out.println(Collections.binarySearch(list, "3")); // 二分查找

    }
}
