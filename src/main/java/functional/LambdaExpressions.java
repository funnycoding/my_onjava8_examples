package functional;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/17 3:44 下午
 */

// LambdaExpressions.java
// 定义了3个接口，其中分别有 无参函数，一个参数的函数，两个参数的函数
// 分别对应不同的 Lambda 示例
interface Description {
    String brief();
}

interface Body {
    String detailed(String head);
}

interface Multi {
    String twoArg(String head, Double d);
}

public class LambdaExpressions {

    // 两个单参数的 Lambda 表达式， 单个参数的表达式 入参可以括起来也可以不括
    static Body bod = h -> h + " No Parens!";
    static Body bod2 = (h) -> h + "More Details";

    // 无参 Lambda 表达式
    static Description desc = () -> "Short info";

    static Description moreLines = () -> {
        System.out.println("moreLines");
        return "frome morelines";
    };

    // 双参数接口 Lambda 表达式
    static Multi multi = (h, n) -> h + n;


    public static void main(String[] args) {
        System.out.println(bod.detailed("Oh!"));
        System.out.println(bod2.detailed("Hi!"));
        System.out.println(desc.brief());
        System.out.println(multi.twoArg("Pi!", 3.1415926));
        System.out.println(moreLines.brief());
    }
}
