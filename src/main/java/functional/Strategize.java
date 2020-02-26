package functional;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description 定义一个接口 分别
 * @date 2020/2/17 1:32 下午
 */


interface Strategy {
    String approach(String msg);
}

class Soft implements Strategy {
    @Override
    public String approach(String msg) {
        return msg.toLowerCase() + "?";
    }
}

// 另一个类，有一个 方法签名与返回值与接口相同的方法，但是没有实现接口
class Unrelated {
    static String twice(String msg) {
        return msg + " " + msg;
    }
}

public class Strategize {
    // 持有接口引用
    Strategy strategy;
    String msg;

    // 初始化测试类的时候同时初始化一个默认的策略，这里是实现了接口的那个类
    public Strategize(String msg) {
        // 初始化 策略对象
        strategy = new Soft(); // 这里默认的策略是 Soft中实现的 将字符串转小写并加一个问号
        this.msg = msg;
    }

    // 打印 approach() 函数的输出
    void communicate() {
        System.out.println(strategy.approach(msg));
    }

    // 更换策略
    void changeStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public static void main(String[] args) {
        // 初始化一个元素是策略对象的数组，第一个元素是一个实现 Strategy 接口的匿名内部类
        // 第二个元素是 使用 Lambda 语法实现的匿名内部类
        // 第三个是 使用方法引用，将 Unrelated 类的 twice 方法引用赋值给 接口 因为 twice 方法的方法签名与返回值与 接口定义的 approach 方法相同
        Strategy[] strategies1 = {
                new Strategy() {
                    @Override
                    public String approach(String msg) {
                        return msg.toUpperCase();
                    }

                    @Override
                    public String toString() {
                        return "匿名对象策略";
                    }
                }, // 第一种对象
                msg -> msg.substring(0, 5), // 第二种
                Unrelated::twice, // 第三种
        };

        Strategize s = new Strategize("Hello there");
        // 输出默认Strategy -> Soft 中的实现
        s.communicate();
        // 遍历策略数组，分别打印不同策略实现的 approach 方法
        for (Strategy newStrategy : strategies1) {
            System.out.println("开始更改策略对象，当前策略对象" + newStrategy);
            s.changeStrategy(newStrategy);
            s.communicate();
        }
    }

}
