package learnJava;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * 日期类
 * Calendar 抽象类和GregorianCalendar 实现类
 *
 */
public class Project_24 {
    public static void main(String[] args) {
        Calendar cal = new GregorianCalendar(2020,6,10,21,54,30);
        System.out.println(cal); //很多属性值
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DATE); //也可以使用 DAY_OF_MONTH
        System.out.println(year);
        System.out.println(month);
        System.out.println(day);

        //设计日期相关元素
        Calendar cal2 = new GregorianCalendar();//使用的当前时间
        System.out.println(cal2);
        System.out.println(cal2.get(Calendar.DAY_OF_WEEK)); //星期日是1，星期一是2，
        cal2.set(Calendar.YEAR, 2020); //修改日期

        //日期的计算
        Calendar cal3 = new GregorianCalendar();
        cal3.add(Calendar.DATE, 100);//往后100天的日期
        System.out.println(cal3);

        //日期对象和事件对象的转化
        Date d3 = cal3.getTime(); //日期转时间

        Calendar cal4 = new GregorianCalendar();
        cal4.setTime(new Date());  //时间转日期

        printCalendar(cal4);
    }

    public  static void printCalendar(Calendar c){
        //打印Calender类 ：xxxx年xx月xx日 xx时xx分xx秒。
        int dayweek = c.get(Calendar.DAY_OF_WEEK)-1;
        if(dayweek == -1){
            dayweek = 7;
        }
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int date = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        System.out.println(year + "年" + month + "月" + date + "日" + "  星期" + dayweek + "  " + hour + "时" + minute + "分"  + second + "秒");
    }
}
