package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/split-with-minimum-sum/description/">2578. 最小和分割</a>
 */
public class SplitNum {

    @Test
    void solution() {
        assertEquals(59, splitNum(4325));
        assertEquals(75, splitNum(687));
    }

    public int splitNum(int num) {
        int[] array = toArray(num);
        Arrays.sort(array);
        int n = array.length;
        int[] a = new int[(n + 1) / 2];
        int[] b = new int[n / 2];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                a[i / 2] = array[i];
            } else {
                b[i / 2] = array[i];
            }
        }
        return toNum(a) + toNum(b);
    }

    private int[] toArray(int num) {
        int n = String.valueOf(num).length();
        int[] arr = new int[n];
        while (num > 0) {
            arr[--n] = num % 10;
            num /= 10;
        }
        return arr;
    }

    private int toNum(int[] arr) {
        int num = 0;
        for (int i : arr) {
            num = num * 10 + i;
        }
        return num;
    }
}
