package reflection;

public class Person {
    public String name;
    int age;
}

interface Move{
    void moveWay();
}

interface Speak{
    void speak();
}

class Student extends Person implements Move, Speak{

    String school;


    public Student setSchool(String school) {
        this.school = school;
        return this;
    }

    public Student() {
    }

    private Student(String school) {
        this.school = school;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void getSchool() {
        System.out.println("学校是" + school);
    }
    @Override
    public void moveWay() {
        System.out.println("自行车绿色出行");
    }

    public int moveWay2(int i, int i2) {
        System.out.println("自行车绿色出行");
        return i+i2;
    }

    @Override
    public void speak() {
        System.out.println("多国语言，学了就会。");
    }
}
