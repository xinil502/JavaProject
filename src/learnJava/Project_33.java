package learnJava;

import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap的使用,
 *
 * 实现comparable接口的compareTo方法来自定义排序
 *
 * HashMap                     HashTable       TreeMap(需要排序时使用)
 * 线程不安全                 线程安全
 * 不允许key或value为null     允许key或value为null
 *
 */
public class Project_33 {
    public static void main(String[] args) {
        Map<Integer, String> treeMap1 = new TreeMap<>();
        treeMap1.put(3, "aa");
        treeMap1.put(7, "ss");
        treeMap1.put(0, "dd");

        // 按照key增加的顺序进行自动排序。
        for(Integer key: treeMap1.keySet()){
            System.out.println(key + "---" + treeMap1.get(key));
        }


        Map<Emp, String> treeMap2 = new TreeMap<>();
        treeMap2.put(new Emp(3 , "张三",1000), "张三是个好小伙");
        treeMap2.put(new Emp(8, "李四", 3000),"李四工作不错");
        treeMap2.put(new Emp(11,"王五", 2000),"王五早睡早起");
        // 按照key增加的顺序进行自动排序。（key进行了自定义比较）
        for(Emp key: treeMap2.keySet()){
            System.out.println(key + "---" + treeMap2.get(key));
        }
    }
}


class Emp implements Comparable<Emp> { //测试类（自定义实现了类比较方法）
    int id;
    String name;
    double salary;

    public Emp(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int compareTo(Emp o){
        if(this.salary > o.salary){
            return 1;
        }else if(this.salary < o.salary){
            return -1;
        }else{
            if(this.id > o.id){
                return 1;
            }else if(this.id < o.id){
                return -1;
            }else{
                return 0;
            }
        }
    }
}