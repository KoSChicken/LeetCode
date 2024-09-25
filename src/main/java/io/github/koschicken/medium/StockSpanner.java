package io.github.koschicken.medium;

import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/online-stock-span/description/">901. 股票价格跨度</a>
 */
public class StockSpanner {

    // 递减的单调栈，栈内元素数组为[股票日期, 股票价格]
    private final LinkedList<int[]> stack = new LinkedList<>();
    // 股票日期
    private int index = 0;

    public StockSpanner() {
        stack.push(new int[]{0, Integer.MAX_VALUE});
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // 返回 1
        System.out.println(stockSpanner.next(80)); // 返回 1
        System.out.println(stockSpanner.next(60)); // 返回 1
        System.out.println(stockSpanner.next(70)); // 返回 2
        System.out.println(stockSpanner.next(60)); // 返回 1
        System.out.println(stockSpanner.next(75)); // 返回 4 ，因为截至今天的最后 4 个股价 (包括今天的股价 75) 都小于或等于今天的股价。
        System.out.println(stockSpanner.next(85)); // 返回 6
    }

    public int next(int price) {
        index++; // 设置今天的股票日期。例如这次调用是第一天，则index是1
        while (price >= stack.peek()[1]) {
            // 如果今日股价比栈顶的大，就将栈顶元素移除，直到今日股价比栈顶的股价小。这样就保证了栈内股价的顺序
            stack.pop();
        }
        // 计算今天的股票日期和上一个比今日股价大的日期的差值
        int next = index - stack.peek()[0];
        // 将今日股价入栈
        stack.push(new int[]{index, price});
        return next;
    }
}
