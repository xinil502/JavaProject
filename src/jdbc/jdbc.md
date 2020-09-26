# JDBC学习笔记

## 一、JDBC的基本执行步骤

```java
1、注册驱动
2、获取连接(连接需要释放)
3、获取数据库操作对象。（对象需要释放）
4、执行sql
5、处理查询结果（如果是查询语句，查询结果集需要释放）
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
conn.close();
~~~

### 3.获取对应数据库操作对象

```java
stmt = conn.createStatement();
stmt.close();
```

### 4.执行SQL语句，处理返回值

**注意**：SQL语句不用写分号。

int executeUpdate(String sql)  

* 专门执行DML语句，增删改(INSERT/DELETE/UPDATE)
* 返回值为被修改的记录条数

ResultSet executeQuery(String sql)   查询

* 专门执行查询语句。
* 返回值为ResultSet结果集，，使用完成后需要释放

#### 1.修改数据

```java
String sql = "INSERT INTO dept VALUES(50,'其他部门','北京')";
int count = stmt.executeUpdate(sql);
```

#### 2.查询数据

Resulet结果集处理

  * 结果集起始位于第一行数据的前一行。

  * `boolean next()`后移一位，并判断移动后的位置是否有数据

  * `String getString(参数)` 不管数据类型是什么，都以String取出

  * `Int getInt(参数)`   以特定类型取出

       参数：

       * `int index`：列数，从1开始。

         *  `String 字段值`：查询结果集的列名

```java
String sql = "SELECT empno a,ename,sal FROM emp";
rs = stmt.executeQuery(sql);

while(rs.next()){
    System.out.println(rs.getInt("a")
        + "\t"+ rs.getString(2)
		+ "\t" + rs.getDouble("sal"));
}
rs.close();
```

### 5.释放资源

* 数据库连接释放
* 数据库对象释放
* 查询结果集释放

## 二、解决SQL注入问题

### 1.PreparedStatement解决SQL注入问题

    *  使用户输入的信息不参与编译过程，问题就解决了。
    *  即使用户的信息含有关键字，也不会起作用。
    *  PreparedStatement 继承了 java,sql.Statement
    *  PreparedStatement 预先对 SQL 框架进行编译，然后只能对框架传值。

### 2.PreparedStatement 和 Statement 的比较

* Statement有SQL注入问题，PreparedStatement解决了注入问题。

* Statement是编译SQL语句一次，执行一次。 

  PreparedStatement是编译一次，可以执行N次。

* PreparedStatement会在编译时进行类型检查。

* PreparedStatement 使用较多。

  极少数使用 Statement(业务方面要求修改SQL语句结构式，必须支持SQL注入)。

### 3.使用PreparedStatement步骤

* 1.单独一个 ? 作为占位符  , 一个 ? 接收一个值.传给DBMS进行预编译。
* 2.ps.set数据类型(parameterIndex, x)传对应数据类型的值：
  * parameterIndex：第一个问号的下标是1，第二个问号的下标是2。
  * x: 传入的值。
  * 如果数据类型是String，会在前后自动加'，不需要在值里面加了
* 3.ps.executeUpdate()/ps.executeQuery() 执行SQL语句。

```java
PreparedStatement ps = conn.prepareStatement("SELECT empno a,ename,sal FROM emp WHERE ename = ?"); //获取预编译的数据库操作对象，并编译SQL框架
ps.setString(1,"SMITH");  //传递参数至预编译的框架
ResultSet rs = ps.executeQuery(); //执行语句

```

## 三、JDBC事务管理

Connection 对象 
* setAutoCommit(boolean b)
  * 设置提交机制： true.选择自动提交，false.选择手动提交。
* commit() 提交事务
* rollback()  出现异常，回滚事务

```java
try {
    conn.setAutoCommit(false);  //设为手动提交事务。
    
    ps = conn.prepareStatement("INSERT INTO dept VALUES(60,'特殊部门','陕西')");
    ps.executeUpdate();
    
    conn.commit();   //手动提交事务
} catch (Exception e) {
    e.printStackTrace();
}finally {
    try {
        if(conn != null){
            conn.rollback();   //出现异常，事务回滚。
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
```

