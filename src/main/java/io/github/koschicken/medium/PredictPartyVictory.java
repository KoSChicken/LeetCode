package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/dota2-senate/">649. Dota2 参议院</a>
 */
public class PredictPartyVictory {

    @Test
    void solution() {
        // assertEquals(predictPartyVictory("RD"), "Radiant");
        // assertEquals(predictPartyVictory("RDD"), "Dire");
        // assertEquals(predictPartyVictory("DRRDRDRDRDDRDRDR"), "Radiant");
        assertEquals(predictPartyVictory("DDRRRR"), "Radiant");
    }

    public String predictPartyVictory(String senate) {
        LinkedList<Integer> radiant = new LinkedList<>();
        LinkedList<Integer> dire = new LinkedList<>();
        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'R') {
                radiant.offer(i);
            } else {
                dire.offer(i);
            }
        }
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            int r = radiant.poll();
            int d = dire.poll();
            if (r < d) {
                radiant.offer(r + senate.length());
            } else {
                dire.offer(d + senate.length());
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
