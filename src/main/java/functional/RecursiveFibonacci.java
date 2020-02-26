package functional;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description 使用 Lambda 来完成 斐波那契数列
 * @date 2020/2/17 4:23 下午
 */

// RecursiveFibonacci.java
public class RecursiveFibonacci {
    // 算法接口引用
    IntCall fib;

    // 将生成斐波那契数列的算法放在构造函数中，生成类的同时也生成了算法的实例对象
    public RecursiveFibonacci() {
        fib = n -> n == 0 ? 0 :
                n == 1 ? 1 :
                        fib.call(n - 1) + fib.call(n - 2);
    }

    // 调用生成斐波那契数列的函数 ，这层封装只是为了更强的语义性，直接调用 fib.call 也是一样的效果
    int generatorFibonacci(int n) {
        return fib.call(n);
    }

    public static void main(String[] args) {
        RecursiveFibonacci rf = new RecursiveFibonacci();
        for (int i = 0; i <= 10; i++) {
            System.out.println(rf.generatorFibonacci(i));
            //System.out.println(rf.fib.call(i)); // 效果和 rf.generatorFibonacci(i) 一样
        }
    }
}
