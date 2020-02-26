package functional;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/17 6:23 下午
 */

// MultiUnbound.java 这里我把接口 和 This类的顺序调换了一下，我感觉更好理解
// 这里接口的第一个入参都是 This 类型，因为未绑定方法的引用赋值需要隐式this来调用
interface TwoArgs {
    void call2(This athisRef, int i, double d);
}

interface ThreeArgs {
    void call3(This athis, int i, double d, String s);
}

interface FourArgs {
    void call4(
            This athis, int i, double d, String s, char c);
}

// 分别对应接口的 2，3，4 入参的函数

class This {
    void two(int i, double d) {
        System.out.println(i + ", " + d + " -> two");
    }

    void three(int i, double d, String s) {

    }

    void four(int i, double d, String s, char c) {

    }
}


public class MultiUnbound {
    public static void main(String[] args) {
        TwoArgs twoArgs = This::two;
        ThreeArgs threeArgs = This::three;
        FourArgs fourArgs = This::four;

        This aThis = new This();
        twoArgs.call2(aThis, 11, 3.14);
        threeArgs.call3(aThis, 11, 3.14, "Three");
        fourArgs.call4(aThis, 11, 3.14, "Four", 'Z');

    }
}
