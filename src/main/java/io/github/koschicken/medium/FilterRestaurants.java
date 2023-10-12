package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/filter-restaurants-by-vegan-friendly-price-and-distance/description/">1333. 餐厅过滤器</a>
 */
public class FilterRestaurants {

    @Test
    void solution() {
        // 输入：restaurants = [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]], veganFriendly = 1, maxPrice = 50, maxDistance = 10
        // 输出：[3,1,5]
        List<Integer> filtered = filterRestaurants(new int[][]{{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}}, 1, 50, 10);
        assertEquals(filtered, Arrays.asList(3, 1, 5));
//        [[1,4,1,40,10],[2,8,0,50,5],[3,8,1,30,4],[4,10,0,10,3],[5,1,1,15,1]]
//			0
//			50
//			10
        List<Integer> filtered2 = filterRestaurants(new int[][]{{1, 4, 1, 40, 10}, {2, 8, 0, 50, 5}, {3, 8, 1, 30, 4}, {4, 10, 0, 10, 3}, {5, 1, 1, 15, 1}}, 0, 50, 10);
        assertEquals(filtered2, Arrays.asList(4, 3, 2, 1, 5));
    }

    public List<Integer> filterRestaurants(int[][] restaurants, int veganFriendly, int maxPrice, int maxDistance) {
        return Arrays.stream(restaurants)
                .filter(veganFriendly == 1 ? restaurant -> restaurant[2] == veganFriendly : restaurant -> true)
                .filter(restaurant -> restaurant[3] <= maxPrice)
                .filter(restaurant -> restaurant[4] <= maxDistance)
                .sorted(this::compare)
                .map(restaurant -> restaurant[0]).toList();
    }

    private int compare(int[] o1, int[] o2) {
        if (o1[1] == o2[1]) {
            return o2[0] - o1[0];
        } else if (o1[1] > o2[1]) {
            return -1;
        } else {
            return 1;
        }
    }
}
