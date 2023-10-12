package io.github.koschicken.easy;

/**
 * <a href="https://leetcode.cn/problems/sqrtx/description/">69. x 的平方根 </a>
 */
public class MySqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt1(2147395599));
        System.out.println(mySqrt2(2147395599));
        System.out.println((int) Math.sqrt(2147395599));
    }

    /**
     * 二分查找
     */
    private static int mySqrt1(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    /**
     * 牛顿法
     */
    private static int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        double r = x;
        double y = (r + x / r) / 2;
        int count = 0;
        while (Math.abs(r - y) > 1e-12) {
            count++;
            r = y;
            y = (r + x / r) / 2;
        }
        System.out.println("运算次数：" + count);
        System.out.println(r);
        return (int) Math.floor(r);
    }
}
