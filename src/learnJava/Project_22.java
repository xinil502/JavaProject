package learnJava;

import java.util.Date;

/*
 * 时间处理相关类
 *
 */
public class Project_22 {
    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());

        Date d = new Date(); //不传参，当前电脑时刻。
        Date d2 =new Date(1591527749352L);//传参，显示传参时间（我学习这节课内容的时间）
        System.out.println(d);//星期 月 日 时分秒 年
        System.out.println(d2);

        //转成毫秒 比较或者使用after比较
        System.out.println("####################");
        System.out.println(d.after(d2));
        System.out.println(d.before(d2));
        System.out.println(d2.getTime());

        //日期处理使用Calendar类
    }
}
