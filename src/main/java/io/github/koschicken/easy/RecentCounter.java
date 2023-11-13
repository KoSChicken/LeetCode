package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/number-of-recent-calls/description/">933. 最近的请求次数</a>
 */
public class RecentCounter {

    private final LinkedList<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }

    @Test
    void solution() {
        RecentCounter recentCounter = new RecentCounter();
        assertEquals(recentCounter.ping(1), 1);
        assertEquals(recentCounter.ping(100), 2);
        assertEquals(recentCounter.ping(3001), 3);
        assertEquals(recentCounter.ping(3002), 3);
    }

    /**
     * 队列里只包括最后一次调用时间-3000的记录，超过范围就出队，则队列长度就是要返回的值
     */
    public int ping(int t) {
        queue.offer(t);
        if (queue.isEmpty()) return 0;
        while (queue.peek() != null && queue.peek() < t - 3000) {
            queue.poll();
        }
        return queue.size();
    }
}