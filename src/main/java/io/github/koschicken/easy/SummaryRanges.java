package io.github.koschicken.easy;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {

    public static void main(String[] args) {
        System.out.println(summaryRanges(new int[]{0, 1, 2, 4, 5, 7}));
        System.out.println(summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
        System.out.println(summaryRanges(new int[]{-2147483648, -2147483647, 2147483647}));
    }

    private static List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int length = nums.length;
        int i = 0;
        for (int j = 0; j < length; j++) {
            if (j + 1 == length || nums[j] + 1 != nums[j + 1]) {
                StringBuilder sb = new StringBuilder();
                sb.append(nums[i]);
                if (i != j) {
                    sb.append("->").append(nums[j]);
                }
                list.add(sb.toString());
                i = j + 1;
            }
        }
        return list;
    }
}
