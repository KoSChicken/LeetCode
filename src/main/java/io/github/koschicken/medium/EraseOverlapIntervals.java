package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/non-overlapping-intervals/description/">435. 无重叠区间</a>
 */
public class EraseOverlapIntervals {

    @Test
    void solution() {
        // 输入: intervals = [[1,2],[2,3],[3,4],[1,3]]
        // 输出: 1
        // 解释: 移除 [1,3] 后，剩下的区间没有重叠。
        // assertEquals(1, eraseOverlapIntervals(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}}));
        // 输入: intervals = [ [1,2], [1,2], [1,2] ]
        // 输出: 2
        // 解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
        // assertEquals(2, eraseOverlapIntervals(new int[][]{{1, 2}, {1, 2}, {1, 2}}));
        assertEquals(7, eraseOverlapIntervals(new int[][]{{-52, 31}, {-73, -26}, {82, 97}, {-65, -11}, {-62, -49}, {95, 99}, {58, 95}, {-31, 49}, {66, 98}, {-63, 2}, {30, 47}, {-40, -26}}));
    }

    public int eraseOverlapIntervals(int[][] intervals) {
        // 按照右端点排序，因为题目只要求未被移除的区间不重复而不要求区间长度，所以这样排好序之后的首个区间必定可以作为保留的首个区间
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int length = intervals.length;
        // 获取首个区间的右端点作为保留区间的右端点。
        // 以此为基准寻找下一个区间（下一个区间的左端点必须大于或等于当前的区间右端点）
        int intervalMax = intervals[0][1];
        // 已经保留了首个区间，所以现在保留区间数必定是1
        int remained = 1;
        // 记录被保留的区间
        // List<int[]> remainedIntervals = new ArrayList<>();
        // 从第二个区间开始查找可以保留的区间
        for (int i = 1; i < length; i++) {
            // 如果当前区间的左端点不和首个区间的右端点重合，说明这个区间可以保留
            if (intervals[i][0] >= intervalMax) {
                // remainedIntervals.add(intervals[i]);
                // 增加保留区间的计数
                remained++;
                // 更新保留区间的右端点
                intervalMax = intervals[i][1];
            }
        }
        // remainedIntervals.forEach(interval -> System.out.println(Arrays.toString(interval)));
        // 因为前面的循环中尽可能的保留了区间，所以 被移除区间的最小数量 = 总区间数量 - 保留区间的数量
        return length - remained;
    }
}
