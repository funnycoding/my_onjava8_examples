package functional;

import java.util.function.Function;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description 函数组合
 * @date 2020/2/18 4:57 下午
 */

// FunctionComposition.java
public class FunctionComposition {

    // 这里声明了4个函数 f4 是前三个的组合
    static Function<String, String> f1 = s -> {
        System.out.println("S1获得了字符串: " + s);
        System.out.println(s);
        return s.replace('A', '_');
    },
            f2 = s -> s.substring(3),

    f3 = s -> {
        System.out.println("f3入参:" + s);
        return s.toLowerCase();
    },
            f4 = f1.compose(f2).andThen(f3); // compose 表示 f2的调用该发生在f1之前 然后调用 s3

    public static void main(String[] args) {
        System.out.println(f4.apply("GO AFTER ALL AMBULAMNCES"));
    }
}
