package generics;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/11 2:42 上午
 */
// Tuple2.java
// 持有2个泛型对象的容器类
public class Tuple2<A, B> {
    // 这里对字段定义为 public final 的意义在于：为不同的元素创建不同的 Tuple2，无法重复对元素赋值
    public final A a1;
    public final B a2;

    public Tuple2(A a1, B a2) {
        this.a1 = a1;
        this.a2 = a2;
    }

    public String rep() {
        return a1 + ", " + a2;
    }

    @Override
    public String toString() {
        return "（" + rep() + ")";
    }
}
