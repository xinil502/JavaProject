package learnJava;
/*
KMP算法，字符串匹配。
 */
import java.util.Scanner;

public class Project13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char[] str1 = str.toCharArray();
        str = sc.next();
        char[] str2 = str.toCharArray();

        int[] next = new int[str2.length];
        next[0] = -1; //next[0]必为-1。
        int i = -1, j = 0;
        while(j<str2.length-1){ //处理模式串，得到next数组。
            if(i == -1 || str2[i] == str2[j]){ //如果匹配则next数组记录i，不存在则回退i的值。
                ++i;
                ++j;
                next[j] = i;
            }else{
                i = next[i];
            }
        }
        /*
        递增判断语句前的i,j。
        递增判断语句后的i,j。
        next数组得到的值。
               a    a    a    a    b    a
        i           -1   0    1    2    3210-1
        j           0    1    2    3    4
        ++i         0    1    2    3    0
        ++j         1    2    3    4    4
     next     -1    0    1    2    3    0


               a    b    c     d    a    b    d
        i           -1   0-1   0-1  0-1  0    1-1
        j           0    1     2    3    4    5
        ++i         0    0     0    0    1    0
        ++j         1    2     3    4    5    6
     next     -1    0    0     0    0    1    0
         */

        i = j = -1;
        while(i<str1.length && j<str2.length){
            if(j == -1 || str1[i] == str2[j]){ //如果j为-1或对应项相等，则推进，否则回退j的位置。
                    ++i;
                    ++j;
            }else{
                    j = next[j];
            }
        }
        if(j == str2.length){
            System.out.println("存在，索引值为："+(i-j));
        }else{
            System.out.println("不存在！");
        }

    }
}
