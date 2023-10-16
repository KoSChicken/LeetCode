package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * <a href="https://leetcode.cn/problems/kids-with-the-greatest-number-of-candies/">1431. 拥有最多糖果的孩子</a>
 */
public class KisdWithCandies {

    @Test
    void solution() {
        assertIterableEquals(kidsWithCandies(new int[]{2, 3, 5, 1, 3}, 3), List.of(true, true, true, false, true));
        assertIterableEquals(kidsWithCandies(new int[]{4, 2, 1, 1, 2}, 1), List.of(true, false, false, false, false));
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        for (int candy : candies) {
            max = Math.max(candy, max);
        }
        List<Boolean> result = new ArrayList<>();
        for (int candy : candies) {
            result.add(candy + extraCandies >= max);
        }
        return result;
    }
}
