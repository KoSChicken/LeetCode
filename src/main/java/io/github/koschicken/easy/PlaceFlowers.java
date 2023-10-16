package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <a href="https://leetcode.cn/problems/can-place-flowers/description/">605.种花问题</a>
 */
public class PlaceFlowers {

    @Test
    void solution() {
        assertTrue(canPlaceFlowers(new int[]{0, 0, 1, 0, 0}, 1));
        assertTrue(canPlaceFlowers(new int[]{1, 0, 0, 0, 1, 0, 0}, 2));
        assertTrue(canPlaceFlowers(new int[]{0, 0, 1, 0, 1}, 1));
        assertTrue(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 1));
        assertFalse(canPlaceFlowers(new int[]{1, 0, 0, 0, 1}, 2));
        assertTrue(canPlaceFlowers(new int[]{1, 0, 1, 0, 1, 0, 1}, 0));
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;
        int[] dummy = new int[length + 2];
        System.arraycopy(flowerbed, 0, dummy, 1, length);
        for (int i = 1; i < dummy.length - 1; i++) {
            if (n == 0) {
                return true;
            }
            if (dummy[i - 1] == 0 && dummy[i + 1] == 0 && dummy[i] != 1) {
                dummy[i] = 1;
                n--;
            }
        }
        return n == 0;
    }
}
