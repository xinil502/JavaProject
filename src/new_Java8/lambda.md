# lambda
## 一、lambda简介
lambda是java8新特性

功能：对接口的简单实现(单一函数)。

接口要求：接口中必须被实现的抽象方法有且只能有一个,不包含default方法，
default方法有默认实现。

@FunctionInterface 在接口前声明该接口为函数接口，只有一个抽象方法。
## 二、lambda基础语法
`
() -> {}
`

() :参数列表。

-> : lambda运算符，读作goes to。

{} : 方法体。
### 语法简洁优化:                                             
1.参数列表中参数数量只有一个时，可以省略小括号。

`Lambda lambda1 = a -> {System.out.println("a");};`

2.方法体中只有一条语句时，可以省略大括号。

`Lambda lambda2 = () -> System.out.println("a");`

3.方法体中唯一的一条语句是返回语句时，省略大括号的同时也要省略return。

`Lambda lambda3 = a -> a*a;`

## 三、lambda方法引用
### 1.普通方法的引用
可以快速的将一个lambda表达式的实现指向一个已经存在的方法。

这个引用方法和接口中定义的方法参数和返回值的数量，类型要完全一致。

语法：方法隶属者(静态归类，非静态归对象) :: 方法名
```java
interface Lambda{
    int test(int a);
}

public class TestLambda {
    public static void main(String[] args) {
        
        Lambda lambda4 = a -> a*a;//正常方法
       
        Lambda lambda5 = TestLambda::pow2;//使用方法引用
        
    }
    
    public static int pow2(int a){
        return a*a;
    }
}
``` 

### 2.构造方法的引用

```java
class Person {
    String name;
    int age;
    
    Person(){
        super();
    }
    
    Person(String name, int age){
        this.name = name;
        this,age = age;
    }
}

interface Lambda1{
     Person getPerson();
}
interface Lambda2{
    Person getPerson(String name, int age);
}

public class TestLambda {
    public static void main(String[] args) {
        
        Lambda1 lambda6 = Person :: new;  //引用无参构造方法。
        Person a = lambda6.getPerson();
       
        Lambda2 lambda7 = Person :: new;  //引用有参构造方法。
        Person b = lambda7.getPerson("任某人", 20);
    }
}
```