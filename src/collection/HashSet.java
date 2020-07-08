package collection;


import java.util.HashMap;

public class HashSet<E> {

    private HashMap<E, Object> map;
    public static final Object PRESENT = new Object();


    public HashSet(){
        map = new HashMap<>();
    }

    public int size(){
        return map.size();
    }
    public void add(Object o){
        map.put((E)o, PRESENT);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for(Object key: map.keySet()){
            sb.append(key+" ");
        }

        sb.setCharAt(sb.length()-1, '}');
        return sb.toString();
    }
}

class TestHashSet{
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("a");

        System.out.println(set.size());
        System.out.println(set);
    }
}