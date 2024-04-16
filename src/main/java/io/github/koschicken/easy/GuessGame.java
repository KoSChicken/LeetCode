package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/guess-number-higher-or-lower/description/">374. 猜数字大小</a>
 */
public class GuessGame {

    @Test
    void solution() {
        int number = guessNumber(2126753390);
        assertEquals(1702766719, number);
    }

    /**
     * Forward declaration of guess API.
     *
     * @param num your guess
     * @return -1 if num is higher than the picked number
     * 1 if num is lower than the picked number
     * otherwise return 0
     * int guess(int num);
     */
    public int guessNumber(int n) {
        int min = 1;
        int max = n;
        while (min < max) {
            int mid = min + (max - min) / 2;
            if (guess(mid) > 0) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }
        return min;
    }

    private int guess(int num) {
        int pick = 1702766719;
        return Integer.compare(pick, num);
    }
}
