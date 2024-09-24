package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 各种组合总和
 */
public class CombinationSum {

    /**
     * <a href="https://leetcode.cn/problems/combination-sum/description/">39. 组合总和</a>
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, candidates, target, path, result);
        return result;
    }

    /**
     * 从[i, candidates.length]中找出比target小的元素，放入path并从target中减去该元素的值，当target减小到0时将path加入result并结束递归
     */
    private void dfs(int i, int[] candidates, int target, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            // 因为数组已经排序，所以如果当前元素过大，则后面的元素一定也过大。
            if (target < candidates[j]) {
                break;
            }
            path.add(candidates[j]);
            // 仍然从头递归，因为可以重复使用元素
            dfs(j, candidates, target - candidates[j], path, result);
            path.remove(path.size() - 1);
        }
    }

    @Test
    void combinationSum() {
        System.out.println(combinationSum(new int[]{2, 3, 6, 7}, 7)); // [[2,2,3],[7]]
    }

    /**
     * <a href="https://leetcode.cn/problems/combination-sum-ii/description/">40. 组合总和II</a>
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        Arrays.sort(candidates);
        dfs2(0, candidates, target, path, result);
        return result;
    }

    private void dfs2(int i, int[] candidates, int target, List<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < candidates.length; j++) {
            // 因为数组已经排序，所以如果当前元素过大，则后面的元素一定也过大。
            if (target < candidates[j]) {
                break;
            }
            // 跳过值相同的元素，因为值相同的元素必定产生值相同的路径
            if (j > i && candidates[j] == candidates[j - 1]) {
                continue;
            }
            path.add(candidates[j]);
            // 与 39.组合总和 不同，这道题不允许重复使用元素，所以要从下一个元素递归
            dfs2(j + 1, candidates, target - candidates[j], path, result);
            path.remove(path.size() - 1);
        }
    }

    @Test
    void combinationSum2() {
        System.out.println(combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8)); // [[1,1,6],[1,2,5],[1,7],[2,6]]
    }

    /**
     * <a href="https://leetcode.cn/problems/combination-sum-iii/description/">216. 组合总和 III</a>
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs3(1, k, Math.min(9, n), n, path, result);
        return result;
    }

    private void dfs3(int i, int k, int n, int target, List<Integer> path, List<List<Integer>> result) {
        if (path.size() == k && target == 0) {
            result.add(new ArrayList<>(path));
        }
        for (int j = i; j <= n; j++) {
            if (target < j || path.size() >= k) {
                break;
            }
            path.add(j);
            dfs3(j + 1, k, n, target - j, path, result);
            path.remove(path.size() - 1);
        }
    }

    @Test
    void combinationSum3() {
        // System.out.println(combinationSum3(3, 7)); // [[1,2,4]]
        // System.out.println(combinationSum3(3, 9)); // [[1,2,6], [1,3,5], [2,3,4]]
        // System.out.println(combinationSum3(4, 1)); // []
        System.out.println(combinationSum3(2, 18)); // [[1,17],[2,16],[3,15],[4,14],[5,13],[6,12],[7,11],[8,10]]
    }

}
