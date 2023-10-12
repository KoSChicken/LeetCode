package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayConcVal {

    @Test
    void solution() {
        assertEquals(findTheArrayConcVal(new int[]{7, 52, 2, 4}), 596);
        assertEquals(findTheArrayConcVal(new int[]{5, 14, 13, 8, 12}), 673);
    }

    public long findTheArrayConcVal(int[] nums) {
        long sum = 0;
        int n = nums.length;
        int i = 0;
        while (i <= n / 2) {
            if (i == n - i || i == n - 1 - i) {
                if (i == n - 1 - i) {
                    sum += nums[i];
                }
                break;
            }
            long concat = concat(nums[i], nums[n - 1 - i]);
            sum += concat;
            i++;
        }
        return sum;
    }

    private long concat(int a, int b) {
        long length = (long) (Math.log10(b) + 1);
        return a * (long) Math.pow(10, length) + b;
    }
}
