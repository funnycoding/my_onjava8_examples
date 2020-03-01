package functional;

import java.util.function.IntSupplier;

/**
 * @author XuYanXin
 * @program aibook-parent
 * @description
 * @date 2020/2/18 3:54 下午
 */

public class Closure3 {
    IntSupplier makeFun(int x) {
       final int i = 0;
        //return () -> x++ + i++;   // x++ 和 i++ 都会报错： 因为 Lambda 中局部变量必须为 等效final的，也就是不能够修改
        return () -> x + i;
    }
}
