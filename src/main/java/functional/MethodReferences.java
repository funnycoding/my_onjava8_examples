package functional;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description 方法引用
 * @date 2020/2/17 4:29 下午
 */

// MethodReferences.java
// 一个方法引用的简单说明例子
interface Callable { // [1]
    void call(String s);
}

class Describe {
    void show(String msg) { // [2]
        System.out.println(msg);
    }
}

public class MethodReferences {
    static void hello(String name) { // [3]
        System.out.println("Hello, " + name);
    }

    // 静态内部类/嵌套类 1
    static class Description {
        String about;

        public Description(String about) {
            this.about = about;
        }

        void help(String msg) { //[4]
            System.out.println(about + " " + msg);
        }
    }

    // 静态内部类/嵌套类 2
    static class Helper {
        static void assist(String msg) { // [5]
            System.out.println(msg);
        }
    }

    public static void main(String[] args) {
        Describe d = new Describe();

        //方法引用语法
        // Describe 的 show() 方法与 Callable 接口的 call() 方法的 方法签名与返回值都一致
        Callable c = d::show; //[6]
        c.call("call"); // [7]  所以这里 Callable 引用 c  调用的 call() 实际调用的是 Describe De show()

        // 同上， MethodReferences 的 hello() 方法与 Call(）方法也一致
        c = MethodReferences::hello; //[8]
        c.call("Bob");

        // 这里是将静态内部类 Descripetion 的 非静态方法 hel() 的引用 赋值给 Callable
        c = new Description("valueable")::help; // [9]
        c.call("information");

        c = Helper::assist; // [10]  静态方法的引用赋值不需要实例对象
        c.call("Help!");
    }

}
