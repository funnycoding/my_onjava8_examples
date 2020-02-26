package functional;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/17 5:16 下午
 */

// RunnableMethodReference.java
// 一个使用匿名内部了/Lambda/方法引用 三种形式 生成实现 Runnable 实例的例子
class Go {
    static void go() {
        System.out.println("Method Reference 实现接口");
    }
}

public class RunnableMethodReference {
    public static void main(String[] args) {

        // 匿名内部类实现 Runnable 接口
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("匿名内部类");
            }
        }).start();

        // Lambda
        new Thread(
                () -> System.out.println("Lambda 实现 Runnable")
        ).start();

        // Method Reference
        new Thread(Go::go).start();
    }
}
