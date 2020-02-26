package functional;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/17 4:13 下午
 */

public class RecursiveFactorial {
    // 声明一个刚才创建的接口的引用
    static IntCall fact;

    public static void main(String[] args) {
        // Lambda 中嵌套了递归
        fact = n -> n == 0 ? 1 : n * fact.call(n - 1);

        for (int i = 0; i < 10; i++) {
            System.out.println(fact.call(i));
        }
    }
}
