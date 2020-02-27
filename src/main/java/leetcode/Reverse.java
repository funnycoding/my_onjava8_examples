package leetcode;

/**
 * @author XuYanXin
 * @program OnJava8_Example
 * @description
 * @date 2020/2/27 12:21 上午
 */

public class Reverse {
    public int reverse(int x) {
        // 定义反转后的数字
        int rev = 0;

        // 开始循环操作 这里因为 x 是int 所以 哪怕最后一位是9  当 9 / 10 的时候，也会被向下舍入，所以最终会为0结束循环。
        while (x != 0) {
            // 开始弹出 x 的第一个栈
            int pop = x % 10;

            // 将 x 缩小十倍
            x /= 10;
            // 找出 rev 越界的情况，返回0
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }

            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            rev = rev * 10 + pop;

        }

        return rev;
    }

    public static void main(String[] args) {
        //System.out.println("MAX" + Integer.MAX_VALUE);
        //int a = Integer.MAX_VALUE / 10;
        //System.out.println(a);
        //System.out.println("MIN" + Integer.MIN_VALUE);
        int i = 9;
        System.out.println( i / 10);
    }
}
