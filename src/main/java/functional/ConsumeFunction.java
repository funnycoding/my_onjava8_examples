package functional;

import java.util.function.Function;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 2:59 下午
 */

// ConsumeFunction.java
class One {
}

class Two {
}

public class ConsumeFunction {
    static Two consume(Function<One, Two> oneTwo) {
        System.out.println("Twos Consume was invoked");
        // 这里其实让我看的挺别扭的，方法的返回值是 Two ，这里 apply的入参却是 One 的实例
        // 不过 apply() 函数的定义是 返回R ，也就是 Two
        // 看懂了，这里的 oneTwo 也就是入参 等价于   Function<One, Two> f = one -> new Two();
        // 调用 f.apply(new One) 也就等于下面 oneTwo.apply(new One());
        return oneTwo.apply(new One());
    }

    public static void main(String[] args) {
        // 这里 consume 函数的入参是一个 Function 这里的入参是一个 Lambda 表达式
        //与下面那句效果相同
        Function<One, Two> f = one -> new Two();
        //  f.apply(new One) 直接可以生成一个 Two 的实例
        Two apply = f.apply(new One());
        System.out.println(apply);

        Two consume = consume(f);
        System.out.println(consume);

        Two two = consume(one -> new Two());
    }
}
