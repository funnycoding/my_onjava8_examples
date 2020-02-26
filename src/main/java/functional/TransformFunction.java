package functional;

import java.util.function.Function;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 3:07 下午
 */

// TransformFunction.java
class I {
    @Override
    public String toString() {
        return "IIII";
    }
}

class O {
    public O() {
        System.out.println("O的构造函数被调用了");
    }

    @Override
    public String toString() {
        return "OOO";
    }
}


public class TransformFunction {
    // 这个方法的入参也是一个 Function 可以看做是一个函数 一种行为
    // 入参是一种行为 返回值也是一种行为，消费行为，生成行为
    // 这里我觉得如果刚开始看不太明白的话，直接通过IDE的功能将 lambda 展开为 匿名内部类 就会看得非常请相互了
    // 这里实现了一个 Function 的匿名内部类，类中的 apply 方法 打印入参 然后不做处理直接返回

    /**
     * 将 Lambda 展开为匿名内部类形式
     * static Function<I, O> transform(Function<I, O> in) {
     * return in.andThen(new Function<O, O>() {
     *
     * @Override public O apply(O o) {
     * System.out.println(o);
     * return o;
     * }
     * });
     * }
     */

    // Lambda
    // 然后在看一下 andThen 函数的定义
    static Function<I, O> transform(Function<I, O> in) {
        System.out.println("transform 被调用了");
        return in.andThen(new Function<O, O>() {
            @Override
            public O apply(O o) {
                System.out.println("apply被调用才进来的");
                System.out.println(o + "ppp");
                return o;
            }
        });
    }

    static MyFuncTest<I, O> transform2(MyFuncTest<I, O> in) {
        System.out.println("transform 被调用了");
        return in.andThen(o -> {
            System.out.println("apply被调用才进来的");
            System.out.println(o+"ppp");
            return o;
        });
    }
    public static void main(String[] args) {
        // 这里我将一步拆为两步 我觉得更直观一些
        // 首先 入参是 i， 返回的是 O 对象，同时打印i  但是这里的返回值 是 Function，方法体内返回的是 O 对象 这是怎样对应上的？
     /*   Function<I, O> ioFunction = // 为什么这个返回这个对象 或者说调用 O 的构造函数，toString 方法被调用了
                TransformFunction::apply;

        System.out.println(ioFunction.apply(new I()));
        System.out.println("-------------");
        // 消费行为，产生行为
        Function<I, O> f2 = transform(ioFunction);
        System.out.println("-------------");
        // 如果不调用 apply 方法， transform 是不会被调用的
        I t = new I();
        System.out.println("apply----------");
        f2.apply(t);*/

        MyFuncTest<I, O> ioFunction = // 为什么这个返回这个对象 或者说调用 O 的构造函数，toString 方法被调用了
                new MyFuncTest<I, O>() {
                    @Override
                    public O apply(I i) {
                        return myApply(i);
                    }
                };

        Function<I,O> f2 = transform(i -> {
            System.out.println(i);
            return new O();
        });

        // 原来打印的 O 是 ioFunction.apply(new I()) 生成的 O 对象 我操了
        System.out.println(ioFunction.apply(new I()));
        System.out.println("-------------");
    }

    private static O myApply(I i) {
        System.out.println("这里是打印i的上一行");
        System.out.println(i);
        System.out.println("这里是return O 的上一行");
        // 为什么这个返回这个对象 或者说调用 O 的构造函数，toString 方法被调用了
        O o = new O();
        System.out.println("构造O"+o);
        return o;
    }
}
