package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * <a href="https://leetcode.cn/problems/keys-and-rooms/description/">841. 钥匙和房间</a>
 * <br/>
 * DFS，递归实现
 */
public class KeysAndRooms {

    @Test
    void solution() {
        // [[1,3],[3,0,1],[2],[0]]
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(List.of(1, 3));
        rooms.add(List.of(3, 0, 1));
        rooms.add(List.of(2));
        rooms.add(List.of(0));
        assertFalse(canVisitAllRooms(rooms));
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()]; // 已访问的房间
        boolean[] keys = new boolean[rooms.size()]; // 已拥有的钥匙
        keys[0] = true; // 0号房间没有锁，默认有钥匙
        for (int i = 0; i < rooms.size(); i++) {
            if (!visited[i]) {
                dfs(rooms, i, visited, keys);
            }
        }
        // 所有的房间都过完后，检查访问记录，有未访问的就是进不去的房间
        for (boolean v : visited) {
            if (!v) {
                return false;
            }
        }
        return true;
    }

    /**
     * 深度优先搜索
     *
     * @param rooms   所有房间列表
     * @param room    当前房间号
     * @param visited 房间访问记录
     * @param keys    钥匙持有记录
     */
    private void dfs(List<List<Integer>> rooms, int room, boolean[] visited, boolean[] keys) {
        if (keys[room]) { // 如果没有持有钥匙直接结束
            visited[room] = true; // 进入房间，标记已访问
            for (int key : rooms.get(room)) {
                keys[key] = true; // 拿取钥匙，更新钥匙持有记录
                if (!visited[key]) { // 看看拿到的钥匙对应的房间有没有访问过，没有访问就进入这个房间
                    dfs(rooms, key, visited, keys);
                }
            }
        }
    }
}
