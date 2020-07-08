package learnJava;

import java.util.*;

public class Project_36 {
    public static void main(String[] args) {
        testIteratorList();
        testIteratorSet();
        teseIteratorMap1();
        teseIteratorMap2();
    }

    public static void testIteratorList() {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < 5; ++i) {
            list.add(i + "");
        }

        for (Iterator<String> iter = list.iterator(); iter.hasNext(); ) {
            System.out.println(iter.next()); //.next()开始时，位于第一个元素之前，使用.next时前移到下一个，并返回对应的元素。
        }
    }

    public static void testIteratorSet(){
        Set<String> set = new HashSet<>();

        for (int i = 0; i < 5; ++i) {
            set.add(i + "");
        }

        for(Iterator<String> iter = set.iterator(); iter.hasNext(); ){
            System.out.println(iter.next());
        }
    }


    public static void teseIteratorMap1() {  //建立键值对集合
        Map<Integer, String> map = new HashMap();

        for (int i = 0; i < 5; ++i) {
            map.put(i, i + 1 + "");
        }

        Set<Map.Entry<Integer, String>> is = map.entrySet();
        for (Iterator<Map.Entry<Integer, String>> iter = is.iterator(); iter.hasNext(); ) {
            Map.Entry<Integer, String> temp = iter.next();
            System.out.println(temp.getKey() + ":" + temp.getValue());
        }
    }

    public static void teseIteratorMap2() {  //建立键集合，用键去访问值
        Map<Integer, String> map = new HashMap();

        for (int i = 0; i < 5; ++i) {
            map.put(i, i + 1 + "");
        }

        Set<Integer> is = map.keySet();
        for (Iterator<Integer> iter = is.iterator(); iter.hasNext(); ) {
            Integer temp = iter.next();
            System.out.println(temp + ":" + map.get(temp));
        }

    }
}