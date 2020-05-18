package learnJava;

public class Project_11 {
    public static void main(String[] args) {
        int[] arr1 = new int[5];
        for(int i=0; i<arr1.length; ++i){
            arr1[i] = i * 2 + 1;
            System.out.println(arr1[i]);
        }

        String[] arr2 = new String[5];
        People[] arr3 = new People[3];
        arr3[0] = new People(4193079, "hyc");
        arr3[1] = new People(4193080, "rjw");
        arr3[2] = new People(4193081, "slw");
        System.out.println(arr3[1].getName());


//        三种初始化方法：
//        1.静态初始化
        int[] a = {1,2,34};
        People[] b = {new People(99, "1号"), new People(100,"2号")};
//        2.默认初始化
        int[] c = new int[3]; //默认给数组元素进行赋值，规则与成员变量一致。
//        3.动态初始化
        int[] d = new int[2];
        d[0] = 0;
        d[1] = 1;


//        使用foreach遍历数组。（用于读取数组元素的值，不能修改）
        for(int i:arr1){
            System.out.println(i);
        }
        for(People i:arr3){
            System.out.println(i.getName());
        }
    }
}

class People{
    private int id;
    private String name;

    public People(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}