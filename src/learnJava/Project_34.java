package learnJava;

/**
 * HashSet (使用HashMap的Key值储存 )
 */

import java.util.HashSet;
import java.util.Set;

public class Project_34 {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();

        set1.add("aa");
        set1.add("bb");
        set1.add("aa");
        System.out.println(set1);
        System.out.println(set1.remove("aa"));
        System.out.println(set1);

        Set<String> set2 = new HashSet<>();
        set2.add("aa");
        set1.add("bb");
        set2.add("cc");
        set1.addAll(set2);
        System.out.println(set1);

    }
}
