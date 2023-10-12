package io.github.koschicken.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/happy-number">202. 快乐数</a>
 */
public class IsHappy {

    public static void main(String[] args) {
        System.out.println(isHappy(10));
    }

    public static boolean isHappy(int n) {
        Set<Integer> sad = new HashSet<>();
        while (n != 1) {
            if (sad.add(n)) {
                n = sum(n);
            } else {
                return false;
            }
        }
        return true;
    }

    private static int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
}
