package functional;

import java.util.function.Function;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 2:53 下午
 */

// ProduceFunction.java
// 继承了 Function 接口，实现了自定义的类名

interface FuncSS extends Function<String, String> {
} // [1]

public class ProduceFunction {
    // 返回值是 Funcss 接口的实例，实际是返回了一个实现接口的类，这里是一个函数
    // 但是其实我还是认为这里返回的是一个类
    static FuncSS produce() {
        return s -> s.toLowerCase(); // [2]
    }

    public static void main(String[] args) {
        FuncSS f = produce();
        System.out.println(f.apply("YELLING"));
    }
}
