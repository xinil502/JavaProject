package learnJava;

import java.util.Arrays;

/*
 * 多维数组
 *
 */
public class Project_18 {
    public static void main(String[] args) {
        //int[] a = new int[3]; 建好一个长度为3的整数数组
        //Project_18[] pro = new Project_18[3]; 建好一个长度为3的对象数组
        int[][] a = new int[3][];
        a[0] = new int[2];
        a[0][0] = 2;
        a[0][1] = 3;
        a[1] = new int[]{1, 4, 8};
        a[2] = new int[]{5, 6};
        for(int[] i:a){
            System.out.println(Arrays.toString(i));
        }

        int[][] b = {
                {2, 3},
                {1, 4, 8},
                {5, 6}
        };
    }
}
