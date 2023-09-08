package io.github.koschicken.easy;

public class MySqrt {

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
        System.out.println((int) Math.sqrt(2147395599));
    }

    /**
     * 牛顿法
     */
    private static int mySqrt(int x) {
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
