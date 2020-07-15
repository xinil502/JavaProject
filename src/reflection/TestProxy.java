package reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        ITestInterface test  = new TestDemoClass();
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
         *
         * 如果一个对象想要被 Proxy.newProxyInstance方法被代理
         *
         *那么这个对象一定要有相应的接口，就像TestDemoClass和 ITestInterface
         */
        InvocationHandler handler = new ProxyDemo(test); //传入代理对象
        /**
         * 参数 ： 代理对象的类加载器     被代理的对象的接口    代理对象
         *  返回值是成功被代理后的对象（返回Object类型，，需要强制转换）
         */
        ITestInterface itd = (ITestInterface) Proxy.newProxyInstance(handler.getClass().getClassLoader(), test.getClass().getInterfaces(), handler);
        itd.test1();
    }
}



/**
 *
 * 动态代理类
 */
class ProxyDemo implements InvocationHandler{

    Object obj; //被代理的对象

    public ProxyDemo(Object obj){
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



interface ITestInterface{
    void test1();
    void test2();
}

class TestDemoClass implements ITestInterface{

    @Override
    public void test1() {
        System.out.println("执行test1方法");
    }

    @Override
    public void test2() {
        System.out.println("执行test2方法");
    }
}
