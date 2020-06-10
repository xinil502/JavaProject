package learnJava;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * DateFormat抽象类 和 SimpleDateFormat 实现类的使用
 */
public class Project_23 {
    public static void main(String[] args) throws ParseException {
        // 抽象类不能被new
        //按照制定格式转成相应字符串
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = df.format(new Date());//当前时间转字符串
        System.out.println(str);


        //按照字符串转成相应日期格式
        DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        Date date = df2.parse("2020年06月07日 20时10分08秒");
        System.out.println(date);

        //其他格式字符
        DateFormat df3 = new SimpleDateFormat("D");
        String str2 = df3.format((new Date()));
        System.out.println(str2); //今天第多少天
    }
}
