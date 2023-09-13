package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MissingNumber {

    @Test
    void solution() {
        assertEquals(missingNumberUsingHash(new int[]{3, 0, 1}), 2);
        assertEquals(missingNumberMath(new int[]{3, 0, 1}), 2);
    }

    public int missingNumberUsingHash(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (set.add(i)) {
                return i;
            }
        }
        return -1;
    }

    public int missingNumberMath(int[] nums) {
        return (nums.length + 1) * nums.length / 2 - Arrays.stream(nums).sum();
    }
}
