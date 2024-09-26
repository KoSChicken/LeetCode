package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/">1318. 或运算的最小翻转次数</a>
 */
public class MinFlips {

    @Test
    void solution() {
        assertEquals(3, minFlips(2, 6, 5));
        assertEquals(1, minFlips(4, 2, 7));
        assertEquals(0, minFlips(1, 2, 3));
    }

    public int minFlips(int a, int b, int c) {
        if ((a | b) == c) {
            return 0;
        }
        int flip = 0;
        for (int i = 0; i < 32; i++) {
            // 将数字本身和左移i位的1按位与，如果结果是0，说明从低到高第i位是0，否则是1
            int aBit = (a & (1 << i)) != 0 ? 1 : 0;
            int bBit = (b & (1 << i)) != 0 ? 1 : 0;
            int cBit = (c & (1 << i)) != 0 ? 1 : 0;
            if ((aBit | bBit) != cBit) {
                if (cBit == 1) {
                    // c的当前位是1，a和b当前位必定都是0，翻转其中一个即可
                    flip++;
                } else {
                    // c的当前位是0，a和b有两种情况：1. 都是0，两个都翻转 2. 有一个是0，翻转一次
                    if (aBit == bBit) {
                        flip += 2;
                    } else {
                        flip++;
                    }
                }
            }
        }
        return flip;
    }

}
