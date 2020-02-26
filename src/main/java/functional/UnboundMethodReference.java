package functional;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description 没有方法引用的对象
 * @date 2020/2/17 5:56 下午
 */

// UnboundMethodReference.java
class X {
    String f() {
        return "X::f()";
    }
}

interface MakeString {
    String make();
}

interface TransformX {
    String transform(X x);
}

public class UnboundMethodReference {
    public static void main(String[] args) {
        MakeString ms = new X()::f; // [1]
        // 这里的方法引用赋值如果是第一次的话会很懵逼
        // 方法签名既不一致，而且 f() 也不是静态方法，为什么可以使用 类::方法的形式
        // 仔细观察方法的入参 有惊喜
        TransformX sp = X::f;

        X x = new X();

        System.out.println(sp.transform(x)); //[2]
        System.out.println(x.f()); // 效果同 [2]1
        System.out.println(ms.make()); // 效果同上
    }
}
