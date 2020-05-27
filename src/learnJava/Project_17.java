package learnJava;

import java.util.Arrays;
/*
 * 数组的扩容和拷贝。
 *
 */
public class Project_17 {
    public static void main(String[] args) {

        String[] str1 = { "J", "a", "v", "a", "中" };
        String[] str2 = { "如", "何", "把", "两", "个", "数", "组", "合", "并", "为",
                "一", "个" };
        int strLen1 = str1.length;// 保存第一个数组长度
        int strLen2 = str2.length;// 保存第二个数组长度
        str1 = Arrays.copyOf(str1, strLen1 + strLen2);// 扩容
        System.arraycopy(str2, 0, str1, strLen1, strLen2);
        // 被拷贝的数组，起始索引值，拷贝至的数组，起始索引值，拷贝长度

        //java.util.Arrays 工具类
        System.out.println(Arrays.toString(str1)); //原格式输出数组

        int[] nums = {1, 2, 2, 3, 1, 7, 6, 3, 2, 7};
        Arrays.sort(nums); //从小到大排序
        System.out.println(Arrays.toString(nums)); //输出排序结果
        System.out.println(Arrays.binarySearch(nums,3)); //对已排序的数组进行二分查找
        System.out.println(Arrays.binarySearch(nums,9)); //return -(二分查找最后一次的左边界索引值-1)
    }
}
