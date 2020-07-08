package learnJava;

/**
 * TreeSet 和  TreeMap一样，按递增排序
 * 可以使用 comparable接口的compareTo方法来自定义排序
 */

import java.util.Set;
import java.util.TreeSet;

public class Project_35 {
    public static void main(String[] args) {
        Set<Integer> set= new TreeSet<>();

        set.add(300);
        set.add(200);
        set.add(300);
        set.add(100);

        for(Integer a: set){
            System.out.println(a);
        }

        TreeSet<Emp2> set2 = new TreeSet<>();

        set2.add(new Emp2(3 , "张三",1000));
        set2.add(new Emp2(8, "李四", 3000));
        set2.add(new Emp2(11,"王五", 2000));
        // 按照key增加的顺序进行自动排序。（key进行了自定义比较）
        for(Emp2 e: set2){
            System.out.println(e.name);
        }
    }
}


class Emp2 implements Comparable<Emp2> { //测试类（自定义实现了类比较方法）
    int id;
    String name;
    double salary;

    public Emp2(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int compareTo(Emp2 o){
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