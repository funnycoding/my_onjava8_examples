package functional;

import java.util.function.Function;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 5:24 下午
 */

public class CurryingAndPartials {
    // 未柯里化的函数，有多个入参
    static String uncurried(String a, String b) {
        return a + b;
    }

    public static void main(String[] args) {
        // 柯里化函数
        Function<String, Function<String, String>> sum =
                a -> b -> a + b; //[1]
        System.out.println(uncurried("HI ","Ho"));

        Function<String, String> hi = sum.apply("HI "); //[2]
        System.out.println(hi.apply("Ho"));

        // 部分应用
        Function<String, String> sumHi = sum.apply("Hup ");
        System.out.println(sumHi.apply("Ho"));
        System.out.println(sumHi.apply("Hey"));
    }
}
