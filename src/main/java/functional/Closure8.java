package functional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 4:21 下午
 */

public class Closure8 {
    Supplier<List<Integer>> makeFun() {
        // 每次调用 makeFun 返回的都是新的内含一个参数 "1"的不可变的 ArrayList
        final List<Integer> list = new ArrayList<>();
        list.add(1);
        return () -> list;
    }

    public static void main(String[] args) {
        Closure8 closure8 = new Closure8();
        List<Integer> l1 = closure8.makeFun().get();
        List<Integer> l2 = closure8.makeFun().get();
        System.out.println(l1);
        System.out.println(l2);
        l1.add(42);
        l2.add(96);
        System.out.println(l1);
        System.out.println(l2);
    }
}
