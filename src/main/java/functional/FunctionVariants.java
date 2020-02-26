package functional;

import java.util.function.DoubleFunction;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.LongFunction;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 12:59 上午
 */

// FunctionVariants.java
// 一个使用内置函数式接口进行各种基础操作的例子
class Foo {
}

class Bar {
    Foo f;

    public Bar(Foo f) {
        this.f = f;
    }
}

class IBaz {
    int i;

    public IBaz(int i) {
        this.i = i;
    }
}

class LBaz {
    long l;

    public LBaz(long l) {
        this.l = l;
    }
}

class DBaz {
    double d;

    public DBaz(double d) {
        this.d = d;
    }
}


public class FunctionVariants {
    // 使用内置接口，这里 Bar/ IBaz / LBaz / DBaz 与对应接口的函数方法签名和返回值一致
    static Function<Foo, Bar> f1 = f -> new Bar(f);
    static IntFunction<IBaz> f2 = i -> new IBaz(i);
    static LongFunction<LBaz> f3 = l -> new LBaz(l);
    static DoubleFunction<DBaz> f4 = d -> new DBaz(d);

    static ToIntFunction<IBaz> f5 = ib -> ib.i;
    static ToLongFunction<LBaz> f6 = lb -> lb.l;
    static ToDoubleFunction<DBaz> f7 = db -> db.d;

    static IntToLongFunction f8 = i -> i;
    static IntToDoubleFunction f9 = i -> i;
    static LongToIntFunction f10 = l -> (int) l;
    static LongToDoubleFunction f11 = l -> l;
    static DoubleToIntFunction f12 = d -> (int) d;
    static DoubleToLongFunction f13 = d -> (long) d;

    public static void main(String[] args) {
        // 这是生成 Bar 对象的方法么，不太看得懂，这个 apply 是干啥的，得看源码
        Bar b = f1.apply(new Foo());
        // 对象的构建，根据对应的入参
        IBaz ib = f2.apply(11);
        LBaz lb = f3.apply(11);
        DBaz dBaz = f4.apply(11);

        // 获取 对象中的 int
        int i = f5.applyAsInt(ib);
        // 获取对象中的 long
        long l = f6.applyAsLong(lb);
        // 获取对象中的 double
        double d = f7.applyAsDouble(dBaz);

        // int 转 long
        l = f8.applyAsLong(12);
        // int 转 double
        d = f9.applyAsDouble(12);
        // long 转 int
        i = f10.applyAsInt(12);

        // long 转 double
        d = f11.applyAsDouble(12);
        // double 转 int
        i = f12.applyAsInt(13.0);
        // double 转 long
        l = f13.applyAsLong(13.0);
    }
}
