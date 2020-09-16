# 反射机制的学习



## 一、反射简介

Class类是反射的源头

一个JVM中只会有一个Class实例
一个Class对象，是一个加载到JVM中的.class文件
每个类的实例都会记得自己是由哪个Class实例生成的

通过Class可以完整的得到一个类中的完整结构。



## 二、反射的创建方式

```java
Class c0 = Person.class; //通过类名创建
Class c1 = p.getClass(); //通过类的实例 的getClass()方法创建
try {
    //通过Class的静态方法获取
    //参数是类的全路径(包名+类名)
    Class c2 = Class.forName("reflection.Person");
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}
```

## 三、获取父类和实现的接口

```java
Class cp = c.getSuperclass();//获取父类
System.out.println(c + "的父类：" + cp);

Class[] interfaces = c.getInterfaces();//获取当前类实现的的所有接口
int i=1;
for(Class temp: interfaces){
    System.out.println(c + "的接口" + i + ":" + temp);
    ++i;
}
```

## 四、获取构造方法名称，修饰符，参数类型

### 1、获取构造方法

```java
Constructor[] cons1 = c.getConstructors();//获取类共有的构造方法
```

```java
Constructor[] cons2 = c.getDeclaredConstructors(); //获取类所有的构造方法
```

### 2.获取修饰符

```java
temp.getModifiers(); 
```

### 3.获取参数类型

```java
Class[] param = temp.getParameterTypes();
```

## 五、通过反射类获得构造器创建对象



```java
Object obj0 = c.newInstance(); //调用了类的无参公共构造器
Student stu0 = (Student)obj0;
stu0.moveWay();
```

```java
Constructor con1 = c.getConstructor(String.class, int.class); //调用公共类指定参数的构造方法。
Object obj1 = con1.newInstance("rjw", 18);

Student stu1 = (Student) obj1;
stu1.school = "西安邮电大学";
System.out.println(stu1.school + stu1.name + stu1.age);
```

```java
Constructor con2= c.getDeclaredConstructor(String.class); //可以获取所有的指定参数的构造方法
con2.setAccessible(true); //解除私有的封装，接下来就可以调用这个方法了。

Object obj2 = con2.newInstance("西安邮电大学");
Student stu2 = (Student) obj2;
System.out.println((stu2).school);
```

## 六、获取类的方法名

```java
Method[] ms = c.getMethods(); //获取类的公有的方法。
```

```java
Method[] ms = c.getDeclaredMethods(); //获取所有的的方法
```

```java
for(Method m: ms){
    System.out.print("方法名" + m.getName());
    System.out.print("返回值类型:" + m.getReturnType());
    System.out.print("修饰符" + m.getModifiers());

    Class[] pcs = m.getParameterTypes();
    System.out.print("参数类型");
    for(Class pc: pcs){
        System.out.print(pc);
    }
    System.out.println();
}
```

## 七、调用类的方法

```java
//使用方法需要两个参数：实例化对象，当前方法的 实际参数
//不论下面调用什么方法，都调用的是obj对象的方法

//1.调用重载方法时,修改getMethod（）后面的参数就可以了。
//2. invoke的返回值就是 方法的返回值。
Class c = Class.forName("reflection.Student"); //反射获取类
Constructor con  = c.getConstructor(); //获取无参公共的构造方法
Object obj = con.newInstance();  //构造对象

Mehod m = c.getMethod("moveWay2", int.class, int.class);
//获取“moveWay”方法。 
//参数：方法名，Class<?>... 形参所属类
int a = m.invoke(obj, 2, 3); 
//调用“moveWay”方法
//参数：被调用方法所属的对象，Object... args (实参)

//Method m = c.getDeclaredMethod("moveWay"); //调用私有方法
//m.setAccessible(true);  //解除私有

```

## 八、获取属性信息和包名

### 1.获取类的属性

```java
Field[] fs = c.getFields(); //获取类的公有属性，包含父类的
```

```java
Field[] fs = c.getDeclaredFields(); //获取本类的所有属性（不包括父类），包括私有。
```

```java
for(Field f: fs){
    System.out.println("属性名" + f.getName());
    System.out.println("修饰符" + f.getModifiers());
    System.out.println("属性的类型" + f.getType());

}
```

### 2.获取类的包名

```java
Package p = c.getPackage(); //获取类所在的包
```

## 九、调用指定的属性

```java
Class c = Class.forName("reflection.Student");//反射获取类
Constructor con  = c.getConstructor();//获取构造器
Object obj = con.newInstance();//构造对象
Student stu = (Student)obj;//转为对应对象

Field f = c.getField("name"); //确定要操作的属性f
f.set(stu, "某某");//修改属性值
System.out.println(f.get(stu));//获取属性值
```