package generics;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/3/11 2:56 上午
 */
// onjava/Tuple3.java
// 对泛型类的继承与扩展
public class Tuple3<A, B, C> extends Tuple2<A, B> {
    public final C a3;

    public Tuple3(A a1, B a2, C c) {
        super(a1, a2);
        a3 = c;
    }
    @Override
    public String rep() {
        return super.rep() + ", " + a3;
    }
}
