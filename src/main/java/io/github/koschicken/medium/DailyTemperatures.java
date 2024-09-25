package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * <a href="https://leetcode.cn/problems/daily-temperatures/description/">739. 每日温度</a>
 */
public class DailyTemperatures {

    @Test
    void solution() {
        // 输入: temperatures = [73,74,75,71,69,72,76,73] 输出: [1,1,4,2,1,1,0,0]
        assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0}, dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        // 输入: temperatures = [89,62,70,58,47,47,46,76,100,70] 输出: [8,1,5,4,3,2,1,1,0,0]
        assertArrayEquals(new int[]{8, 1, 5, 4, 3, 2, 1, 1, 0, 0}, dailyTemperatures(new int[]{89, 62, 70, 58, 47, 47, 46, 76, 100, 70}));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] result = new int[length];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            int temperature = temperatures[i];
            // 循环：如果栈不为空且当日温度大于栈顶日期的温度，则把栈顶弹出，并计算当天和栈顶日期的差值，差值是栈顶日期到下次升温的天数
            while (!deque.isEmpty() && temperature > temperatures[deque.peek()]) {
                Integer top = deque.pop();
                result[top] = i - top;
            }
            deque.push(i);
        }
        return result;
    }
}
