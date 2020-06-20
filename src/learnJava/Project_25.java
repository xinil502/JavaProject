package learnJava;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/*
 * File类的基本用法
 */
public class Project_25 {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\admin\\Desktop\\rename.txt"); //用/或\\去表示路径
        f.createNewFile(); //新建对应路径的文件。
        f.renameTo(new File("C:\\Users\\admin\\Desktop\\renamed.txt")); //改名操作
        System.out.println(f); //显示路径

        f = new File("C:\\Users\\admin\\Desktop\\renamed.txt");
        System.out.println("File是否存在" + f.exists());
        System.out.println("File是否是目录" + f.isDirectory());
        System.out.println("File是否是文件" + f.isFile());
        System.out.println("File最后修改时间" + new Date(f.lastModified()));
        System.out.println("File的大小" + f.length());
        System.out.println("File的文件名" + f.getName());
        System.out.println("File的目录路径" + f.getPath());
        f.delete();


        //mkdir的使用
        File f3 = new File("C:\\Users\\admin\\Desktop\\a\\b\\c\\d");
        boolean mkdir = f3.mkdir(); //中间有目录不存在，无法创建。
        System.out.println(mkdir);
        f3 = new File("C:\\Users\\admin\\Desktop\\a\\b\\c");
        mkdir = f3.mkdirs(); //中间目录不存在也没关系，会创建整个目录树。
        System.out.println(mkdir);
    }

    static void printFile(File file, int level) {
        //输出当前的层
        for (int i = 0; i < level; ++i) {
            System.out.print("-");
        }
        System.out.println(file.getName());

        //输出子层
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File temp : files) {
                printFile(temp, level + 1);
            }
        }
    }
}