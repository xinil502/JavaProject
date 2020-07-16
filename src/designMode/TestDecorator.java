package designMode;

public class TestDecorator {
    public static void main(String[] args) {
        Component component = new ConcreteComponent();
        component.operation();

        //传入被修饰类的对象作为参数，构造 装饰类1 的对象。
        System.out.println("#####################");
        component = new ConreteDecorator1(new ConcreteComponent());
        component.operation();

        //传入装饰者1类作为参数，构造 装饰者2 的对象
        System.out.println("#####################");
        component = new ConreteDecorator2(new ConreteDecorator1(new ConcreteComponent()));
        component.operation();

    }
}

/**
 * 原接口
 */
interface Component{
    void operation();
}

/**
 * 原接口的实现类/被装饰的类
 */
class ConcreteComponent implements Component{

    @Override
    public void operation() {
        System.out.println("被装饰类实现的原方法正在运行");
    }
}

/**
 * 装饰者抽象类
 *
 * 包含 ： 被装饰类的对象， 未实现的原接口方法
 */
abstract class Decorator implements Component{
    Component component;

    public Decorator(Component component) {
        this.component = component;
    }
}

/**
 * 装饰者实现类1
 *
 */
class ConreteDecorator1 extends Decorator{

    public ConreteDecorator1(Component component) {
        super(component);
    }

    public void operation() {
        System.out.println("装饰者1开始装饰，接下来调用装饰者1构造时传入的被装饰对象的operation方法：");
        component.operation();
        System.out.println("装饰者1结束装饰.。。");
    }
}

class ConreteDecorator2 extends Decorator{


    public ConreteDecorator2(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        System.out.println("装饰着2开始装饰，接下来调用装饰者2构造时传入的被装饰对象的operation方法：");
        component.operation();
        System.out.println("装饰着2结束装饰。。。");
    }
}
