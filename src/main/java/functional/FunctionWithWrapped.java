package functional;

import java.util.function.DoubleToIntFunction;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 2:39 下午
 */
// FunctionWithWrapped.java
// 这里涉及到基本类型强转
// 当返回值的精度小于入参的时候需要进行强转
public class FunctionWithWrapped {
    public static double returnD(int i) {
        return i;
    }

    public static int returnI(double d) {
        return (int) d;
    }


    public static void main(String[] args) {
        Function<Integer, Double> fid = i -> (double) i;

        IntToDoubleFunction fid2 = i -> i;
        IntToDoubleFunction fid3 = i -> (double) i;

        // 这里我加了个 使用 double 转 int的内置函数接口，把 returnI 也用上了
        DoubleToIntFunction d = FunctionWithWrapped::returnI;
        double v = returnD(10);
    }
}
