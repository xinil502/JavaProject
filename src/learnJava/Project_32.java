package learnJava;

import java.util.HashMap;
import java.util.Map;

/*
 * Map接口  Map常用方法
 *
 * HashMap  在位捅元素达到 数组长度*0.75 时，，数组长度变为两倍
 *          链表长度 > 8    时   转化为红黑树
 */
public class Project_32 {
    public static void main(String[] args) {
        Map<Integer, String > m1 = new HashMap<>();
        m1.put(1,"one"); //添加键值对(键不能重复)
        m1.put(2, "two");
        m1.put(3, "three");
        m1.put(3, "four");
        System.out.println(m1); //如果键重复，新的覆盖旧的
        System.out.println(m1.size()); //计算大小
        System.out.println(m1.get(1)); //获取对应键值

        System.out.print(m1.containsKey(4) + "   "); //是否包含键
        System.out.println(m1.containsValue("one")); //是否包含值

        m1.remove(1); //根据键，删除键值对
        System.out.println(m1);

        Map<Integer, String> m2 = new HashMap<>();
        m2.put(4, "四");
        m2.put(5, "五");
        m1.putAll(m2);// 将m2中的键值对导入m1中。
        System.out.println(m1);
        System.out.println("##########################");


        Employee e0 = new Employee(4193070, "任基伟0", 50000);
        Employee e1 = new Employee(4193071, "任基伟1", 50001);
        Employee e2 = new Employee(4193072, "任基伟2", 50002);
        Map<Integer, Employee> m3 = new HashMap<>();
        m3.put(0,e0);
        m3.put(1,e1);
        m3.put(2,e2);
        Employee temp = m3.get(1);
        System.out.println(temp.getName());
        System.out.println(m3);
    }
}


class Employee{
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public Employee setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public Employee setSalary(double salary) {
        this.salary = salary;
        return this;
    }

    public String toString(){
        return "  id:" + id + "  name:" + name + "  salary:" + salary + "\n";
    }
}
