package functional;

import java.util.function.Function;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description 函数组合
 * @date 2020/2/18 4:57 下午
 */

public class FunctionComposition {
    static Function<String, String> f1 = s -> {
        System.out.println(s);
        return s.replace('A', '_');
    },
            f2 = s -> s.substring(3),
            f3 = s -> s.toLowerCase(),
            f4 = f1.compose(f2).andThen(f3); // 来了，函数组合它 lei le

    public static void main(String[] args) {
        System.out.println(f4.apply("GO AFTER ALL AMBULAMNCES"));
    }
}
