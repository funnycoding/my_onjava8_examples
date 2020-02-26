package functional;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/17 8:24 下午
 */

// FunctionalAnnotation.java
// 加了这个注解接口就只能存在1个抽象方法
@FunctionalInterface
interface Functional {
    String goodbye(String arg);
}

// 不加注解也没事，注解只是一个强制校验
interface FunctionalNoAnn {
    String goodbye(String arg);
}

/*
@FunctionalInterface
interface NotFunctional {
  String goodbye(String arg);
  String hello(String arg);
}
产生错误信息:
NotFunctional is not a functional interface
multiple non-overriding abstract methods
found in interface NotFunctional
 因为如果使用了 @FunctionalInterface 注解，那么接口中只能存在一个抽象函数
*/


public class FunctionalAnnotation {
    public String classGoodBye(String arg) {
        return "Good bye" + arg;
    }

    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        // 这里可以看出来只要
        Functional f = fa::classGoodBye;
        FunctionalNoAnn fna = fa::classGoodBye;
        // 不能将 fa 的引用赋值给 functional
        //Functional fac = fa; // Incompatible
        // 使用 Lambda形式实现 Function接口的函数
        Functional fl = a -> "GoodBye Lambda," + a;
        Functional fnal = a -> "GoodBye Lambda With No Annotation," + a;

    }
}
