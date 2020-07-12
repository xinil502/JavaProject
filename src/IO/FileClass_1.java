package IO;

/**
 * File 类
 */
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileClass_1 {
        public static void main(String[] args){
            printFile(new File("C:/Users/admin/Desktop"), 0);

            // 创建文件夹，改名，执行一系列操作并删除文件。
            File f = new File("C:\\Users\\admin\\Desktop\\rename.txt"); //用/或\\去表示路径
//      File f1 = new File("C:\\Users\\admin\\Desktop","rename.txt"); 使用分隔符隔开
//      File f2 = new File("C:\\Users\\admin\\Desktop" + File.separator + "rename.txt"); 使用File.separator 隔开

            // 文件创建和删除 creatNewFile    delete
            try{
                f.createNewFile();  //创建对应路径的文件。
            }catch (IOException e){
                e.printStackTrace();
            }
            f.renameTo(new File("C:\\Users\\admin\\Desktop\\renamed.txt")); //改名操作
            System.out.println(f); //显示路径（改变文件名称但不改变对象路径）
            f = new File("C:/Users/admin/Desktop/renamed.txt"); //更改File对象为改变文件名后的对象

            //文件检测
            System.out.println("File是否存在：" + f.exists());
            System.out.println("File是否是文件夹(目录)：" + f.isDirectory()); //
            System.out.println("File是否是文件：" + f.isFile());
            System.out.println("File最后修改时间：" + new Date(f.lastModified()));// 返回最终修改时间的毫秒数
            System.out.println("File的大小：" + f.length()); //单位是字节数
            System.out.println("File的文件名：" + f.getName()); //获取 文件名称 或 文件夹名称
            System.out.println("File的可读：" + f.canRead());
            System.out.println("File的可写：" + f.canWrite());
            f.delete();

            //路径
            System.out.println("#################################");
            File f2 = new File("a.txt"); // 相对路径是相对JVM的启动路径
            System.out.println("f2在new时候的路径：" + f2.getPath());//new绝对就是绝对，new相对就是相对。
            System.out.println("f2的绝对路径：" + f2.getAbsolutePath());// 返回绝对路径
            System.out.println(f2);
            System.out.println("f2的绝对路径对象：" + f2.getAbsoluteFile());// 返回绝对路径的File对象
            System.out.println("f2的父级路径：" + f2.getParent()); //返回当前文件或文件夹的父级路径


            //File类的 mkdir方法和 mkdirs方法的使用
            File f3 = new File("C:\\Users\\admin\\Desktop\\a\\b\\c\\d");
            boolean bool = f3.mkdir(); //中间有目录不存在时，无法创建，返回boolean值。
            System.out.println(bool);

            f3 = new File("C:\\Users\\admin\\Desktop\\a\\b\\c");
            bool = f3.mkdirs(); //中间目录不存在也没关系，会创建整个目录树。
            System.out.println(bool);
        }

        static void printFile(File root, int level) { //先输出自己，再遍历子层。
            //输出当前的层
            for (int i = 0; i < level; ++i) {
                System.out.print("-");
            }
            System.out.println(root.getName());

            //输出子层
            if (root.isDirectory()) {
                File[] files = root.listFiles();
                for (File temp : files) {
                    printFile(temp, level + 1);
                }
            }
        }
    }
