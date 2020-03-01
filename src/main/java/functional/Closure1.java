package functional;

import java.util.function.IntSupplier;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 3:33 下午
 */
// Closure1.java
public class Closure1 {
    int i;
    // 这里使用到了类变量 i
    IntSupplier makeFun(int x) {
        return () -> x + i++;
    }

    public static void main(String[] args) {
        Closure1 closure1 = new Closure1();

        System.out.println(closure1.makeFun(10).getAsInt());
    }
}
