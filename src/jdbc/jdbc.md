# JDBC学习笔记

## 一、JDBC的执行步骤

```java
1、注册驱动
2、获取连接
3、获取数据库操作对象。
4、执行sql
5、处理查询结果
6、释放资源
```

### 1.注册驱动

```java
//使用DriverDanager类的registerDriver方法注册驱动
DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

//使用类加载器注册驱动
Class.forName("com.mysql.cj.jdbc.Driver");
```

### 2.获取连接

**需要参数**：

* IP端口
* 用户名
* 密码

~~~java
/**
 * BufferedReader br = new BufferedReader(new FileReader(new File("src/jdbc/user.properties")));
 * Properties p = new Properties();
 * p.load(br);
 * br.close();
 * String url = p.getProperty("url");
 * String name = p.getProperty("user1");
 * String password = p.getProperty("password1");
 * conn = DriverManager.getConnection(url,name,password);
 */
conn = DriverManager.getConnection(url,name,password);
conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db_1?serverTimezone=UTC&useUnicode=true&characterEncoding=UTF-8", "user1", "pass");

~~~

### 3.获取对应数据库操作对象

```java
stmt = conn.createStatement();
```