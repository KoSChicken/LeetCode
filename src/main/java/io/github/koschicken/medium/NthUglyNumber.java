package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/ugly-number-ii/description/">264. 丑数 II</a>
 */
public class NthUglyNumber {

    @Test
    void solution() {
        assertEquals(12, nthUglyNumber(10));
        assertEquals(1, nthUglyNumber(1));
        assertEquals(36, nthUglyNumber(20));
    }

    public int nthUglyNumber(int n) {
        int[] uglyNumbers = new int[n + 1];
        uglyNumbers[1] = 1;
        // 数组中的任意一个数都是由这个数之前的某个数乘2或者乘3或乘5得来的。
        // 例如前10个丑数，[1, 2, 3, 4, 5, 6, 8, 9, 10, 12]
        // 已经确定第一个丑数是1，从第二个开始，2是由1*2得来的，3是由1*3得来的，4是由2*2得来的，5是由1*5得来的。
        // 所以用3个指针指向数字1，分别计算1与2，3，5的乘积，选择最小的那个放到数组里，然后把对应的指针向后移动一位。
        // 第一轮计算得到3个丑数2，3，5，下一个丑数是其中最小的2，且下一轮中计算的结果肯定不包含2，所以计算出2的指针向后移动一位。
        // 第二轮计算得到3个丑数4，3，5，下一个丑数是其中最小的3，且下一轮中计算的结果肯定不包含3，所以计算出3的指针向后移动一位。
        // 第二轮计算得到3个丑数4，6，5，下一个丑数是其中最小的4，且下一轮中计算的结果肯定不包含4，所以计算出4的指针向后移动一位。
        // ……
        // 根据这个规律，就可以求出第任意个丑数
        int i2 = 1;
        int i3 = 1;
        int i5 = 1;
        for (int i = 2; i <= n; i++) {
            int next2 = 2 * uglyNumbers[i2];
            int next3 = 3 * uglyNumbers[i3];
            int next5 = 5 * uglyNumbers[i5];
            int next = Math.min(next2, Math.min(next3, next5));
            uglyNumbers[i] = next;
            if (next == next2) {
                i2++;
            }
            if (next == next3) {
                i3++;
            }
            if (next == next5) {
                i5++;
            }
        }
        return uglyNumbers[n];
    }
}
