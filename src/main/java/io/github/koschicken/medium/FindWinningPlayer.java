package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/find-the-first-player-to-win-k-games-in-a-row/description/">3175. 找到连续赢 K 场比赛的第一位玩家</a>
 */
public class FindWinningPlayer {

    @Test
    void solution() {
        // 输入：skills = [4,2,6,3,9], k = 2
        // 输出：2
        assertEquals(2, findWinningPlayer(new int[]{4, 2, 6, 3, 9}, 2));
    }

    /**
     * 双指针比较，使用两个指针不断比较：获胜时计数，计数达到k时返回慢指针，落败时将慢指针移动到新的胜者位置，并将获胜数重置为1。
     */
    public int findWinningPlayer(int[] skills, int k) {
        int n = skills.length;
        int count = 0;
        int i = 0;
        for (int j = 1; j < n; j++) {
            if (skills[i] > skills[j]) {
                count++;
            } else {
                count = 1;
                i = j;
            }
            if (count == k) {
                return i;
            }
        }
        return i;
    }

    /**
     * 用一个双端队列来模拟，需要注意的是要处理k超过skills.length的情况
     */
    public int findWinningPlayerWithDeque(int[] skills, int k) {
        if (k >= skills.length) {
            int maxIndex = 0;
            for (int i = 1; i < skills.length; i++) {
                if (skills[i] > skills[maxIndex]) {
                    maxIndex = i;
                }
            }
            return maxIndex;
        }
        Deque<int[]> deque = new ArrayDeque<>();
        for (int i = 0; i < skills.length; i++) {
            deque.add(new int[]{skills[i], i});
        }
        int count = 0;
        while (count < k) {
            int[] first = deque.pop();
            int[] second = deque.pop();
            if (first[0] > second[0]) {
                deque.push(first);
                deque.add(second);
                count++;
            } else {
                count = 1;
                deque.push(second);
                deque.add(first);
            }
        }
        return deque.peek()[1];
    }
}
