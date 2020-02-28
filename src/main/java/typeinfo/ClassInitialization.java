package typeinfo;

import java.util.Random;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/28 7:24 下午
 */

// typeinfo/ClassInitialization.java
class Initable {
    static final int STATIC_FINAL = 47;
    static final int STATIC_FINAL_2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;

    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {
    public static Random rand = new Random(47);

    public static void main(String[] args) throws ClassNotFoundException {
        Class initableClass = Initable.class; // 类的字面量常量

        // 使用字面量常量获得 Class 对象并没有触发类的初始化
        System.out.println("After Creating Initable reference");

        // 打印类的静态常量也不会触发类的初始化
        System.out.println(Initable.STATIC_FINAL);

        System.out.println(Initable.STATIC_FINAL_2);

        System.out.println(Initable2.staticNonFinal);

        Class initable3 = Class.forName("typeinfo.Initable3");

        System.out.println("After Initializing initbale3 Ref");

        System.out.println(Initable3.staticNonFinal);


    }
}
