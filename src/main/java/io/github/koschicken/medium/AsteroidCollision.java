package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * <a href="https://leetcode.cn/problems/asteroid-collision/description/">735. 小行星碰撞</a>
 */
public class AsteroidCollision {

    @Test
    void solution() {
        assertArrayEquals(asteroidCollision(new int[]{5, 10, -5}), new int[]{5, 10});
        assertArrayEquals(asteroidCollision(new int[]{8, -8}), new int[]{});
        assertArrayEquals(asteroidCollision(new int[]{10, 2, -5}), new int[]{10});
        assertArrayEquals(asteroidCollision(new int[]{-2, -1, 1, 2}), new int[]{-2, -1, 1, 2});
        assertArrayEquals(asteroidCollision(new int[]{-2, -2, 1, -1}), new int[]{-2, -2});
        assertArrayEquals(asteroidCollision(new int[]{1, -2, -2, -2}), new int[]{-2, -2, -2});
    }

    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> deque = new ArrayDeque<>();
        int first = asteroids[0];
        deque.push(first);
        for (int i = 1; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            if (asteroid > 0) {
                // 当前小行星向右移动时，无论前一个小行星向哪移动都不会碰撞
                deque.push(asteroid);
            } else {
                // 当前小行星向左移动
                if (!deque.isEmpty() && deque.peek() > 0) {
                    while (true) {
                        if (deque.peek() < 0) {
                            deque.push(asteroid);
                            break;
                        }
                        if (deque.peek() > 0) {
                            // 前面的小行星向右移动
                            if (deque.peek() > Math.abs(asteroid)) {
                                // 当前小行星撞毁
                                break;
                            }
                            if (deque.peek() == Math.abs(asteroid)) {
                                // 同时撞毁
                                deque.pop();
                                break;
                            }
                            // 前面的小行星撞毁
                            deque.pop();
                            if (deque.isEmpty()) {
                                deque.push(asteroid);
                                break;
                            }
                        }
                    }
                } else {
                    deque.push(asteroid);
                }
            }
        }
        int[] result = new int[deque.size()];
        while (!deque.isEmpty()) {
            result[deque.size() - 1] = deque.pop();
        }
        return result;
    }

}
