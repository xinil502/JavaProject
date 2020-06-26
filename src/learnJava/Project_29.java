package learnJava;

/*
 * 泛型
 */
public class Project_29 {
    public static void main(String[] args) {
        MyCollection<String> mc = new MyCollection<>();
        mc.set("rjw", 0);

        String a = (String)mc.get(0);
        System.out.println(a);
    }
}

class MyCollection<E>{
    private Object[] objs = new Object[5];

    public void set(E e, int index){
        objs[index] = e;
    }

    public Object get(int index){
        return (E)objs[index];
    }
}