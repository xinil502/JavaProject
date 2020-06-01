package learnJava;
/*
 *  StringBuilder 和 StringBuffer的基本用法
 */
public class Project_21 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; ++i){
            sb.append((char)('a' + i)); //加入
        }
        System.out.println(sb);

        sb.reverse(); //倒序
        System.out.println(sb);

        sb.setCharAt(3,'任'); //修改
        System.out.println(sb);

        sb.insert(4,'我').insert(4,'是');//插入(很多方法会返回自己，可以链式调用)
        System.out.println(sb);

        //删除一个区间
        sb.delete(10, 20);
        System.out.println(sb);





        //////////////////
//        String s = "";
//        for(int i=0; i<5000; ++i){ // 产生5000个对象
//            s = s + i;
//        }
        StringBuilder sbe = new StringBuilder("");
        for(int i=0; i<5000; ++i){
            sbe.append(i);
        }
    }
}
