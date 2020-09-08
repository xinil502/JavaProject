package io.filecopy;

import java.io.*;

public class FileCopy_1 {
    public static void main(String[] args) {
        FileCopy_1 cop = new FileCopy_1();
        cop.copyFolder(new File("C:\\Users\\admin\\Desktop\\a"), new File("C:\\Users\\admin\\Desktop\\z"));
    }

    void copyFile(File from, File to){
        try {
            if(!to.exists()){
                to.createNewFile();
            }
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(from));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(to));

            byte[] b = new byte[100];
            int len;
            while ((len = bis.read(b)) != -1){
                bos.write(b, 0, len);
            }

            bos.flush();
            bos.close();
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void copyFolder(File from, File to){
        try {
            if(!to.exists()){
                to.mkdirs();
            }
            File[] files = from.listFiles();
            for(File temp: files){
                if(temp.isDirectory()){
                    copyFolder(temp, new File(to.getAbsolutePath() + File.separator + temp.getName()));
                }else{
                    copyFile(temp, new File(to.getAbsolutePath() + File.separator + temp.getName()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
