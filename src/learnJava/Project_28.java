package learnJava;

/*
 * 自定义异常
 */
public class Project_28 {
    public static void main(String[] args) {
        PersonTestExpection p = new PersonTestExpection();
        p.setAge(-6);
    }
}

class PersonTestExpection{
    private int age;

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        if(age < 0){
            throw new IllegalAgeException("年龄不能为负数");
        }
        this.age = age;
    }
}

class IllegalAgeException extends RuntimeException {//若继承Exception则为编译时异常，需要抛出或trycatch

    public IllegalAgeException(){
        super();
    }
    public IllegalAgeException(String msg){ //异常信息
        super(msg);
    }

}
