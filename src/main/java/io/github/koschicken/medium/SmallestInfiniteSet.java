package io.github.koschicken.medium;

import java.util.TreeSet;

/**
 * <a href="https://leetcode.cn/problems/smallest-number-in-infinite-set/description/">2336. 无限集中的最小数字</a>
 * <p>
 * 可以使用TreeSet作为容器，同时维持一个变量存放最小值；
 * </p>
 * <p>
 * 也可以选择使用最小堆作为容器，最小堆可以选择{@link java.util.PriorityQueue}，或者手动实现{@link io.github.koschicken.common.MinHeap}。
 * </p>
 */
public class SmallestInfiniteSet {

    private final TreeSet<Integer> set;
    private int smallest;

    /**
     * 初始化 SmallestInfiniteSet 对象以包含 所有 正整数
     */
    public SmallestInfiniteSet() {
        smallest = 1;
        set = new TreeSet<>();
    }

    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);    // 2 已经在集合中，所以不做任何变更。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 1 ，因为 1 是最小的整数，并将其从集合中移除。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 2 ，并将其从集合中移除。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 3 ，并将其从集合中移除。
        smallestInfiniteSet.addBack(1);    // 将 1 添加到该集合中。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 1 ，因为 1 在上一步中被添加到集合中，且 1 是最小的整数，并将其从集合中移除。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 4 ，并将其从集合中移除。
        System.out.println(smallestInfiniteSet.popSmallest()); // 返回 5 ，并将其从集合中移除。
    }

    /**
     * 移除 并返回该无限集中的最小整数
     */
    public int popSmallest() {
        if (set.isEmpty()) {
            int remove = smallest;
            smallest++;
            return remove;
        }
        return set.pollFirst();
    }

    /**
     * 如果正整数 num 不 存在于无限集中，则将一个 num 添加 到该无限集最后
     */
    public void addBack(int num) {
        if (num < smallest) {
            set.add(num);
        }
    }
}
