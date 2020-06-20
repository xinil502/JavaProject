package learnJava;
/*
 *
 * 简单的枚举类
 */
public class Project_26 {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);

        Season a = Season.AUTUMN;

        switch(a){ //枚举与switch结合
            case SPRING:
                break;
            case SUMMER:
                break;
            case AUTUMN:
                break;
            case WHINTER:
                break;
        }
    }
}

enum Season {
    SPRING, SUMMER, AUTUMN, WHINTER;
}

enum Week{
    星期一, 星期二, 星期三, 星期四, 星期五, 星期六, 星期日
}
