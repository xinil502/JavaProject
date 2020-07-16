package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;


interface TestInterface{
    void test1();
    void test2();
}

class TestObject implements TestInterface{

    @Override
    public void test1() {
        System.out.println("执行test1方法");
    }

    @Override
    public void test2() {
        System.out.println("执行test2方法");
    }
}







public class TestProxy {
    public static void main(String[] args) {
        /**
         * 基本的接口实现，方法调用。
         */
        TestInterface test  = new TestObject();
        test.test1();
        test.test2();

        /**
         * 需求：在执行test1和test2方法时，
         *   需要加入一些东西
         *   执行方法前打印 XXX方法开始执行
         *   执行方法后打印 XXX方法执行完毕
         *
         *   打印的方法名要和调用的方法保持一致。
         */


        /**
         * 提供详细的代理服务。
         *
         * 如果一个对象想要被 Proxy.newProxyInstance方法被代理
         *
         * 那么这个对象一定要有接口，就像TestObject和 TestInterface
         * 进行代理实际上是调用invoke方法，负责做业务
         */
        InvocationHandler handler = new ProxyClass(test); //传入被代理的对象，生成代理对象

        /**
         * 提供代理实例对象。
         *
         * 参数 ： 代理对象的类加载器     原对象的接口    代理对象
         *  返回值是成功被代理后的动态代理对象（返回Object类型，，需要强制转换）
         */
        TestInterface itd = (TestInterface) Proxy.newProxyInstance(handler.getClass().getClassLoader(), test.getClass().getInterfaces(), handler);
        itd.test1();
    }
}



/**
 *
 * 动态代理类
 */
class ProxyClass implements InvocationHandler{

    Object obj; //被代理的对象

    public ProxyClass(Object obj){
        this.obj = obj;
    }

    @Override
    // 该代理方法的实例对象，
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println(method.getName() + "方法开始执行");

        Object result = method.invoke(this.obj,args); //执行制定代理方法。

        System.out.println(method.getName() + "方法执行完毕");

        return result;
    }
}

