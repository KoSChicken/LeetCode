package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PassThePillow {

    @Test
    void solution() {
        int passed = passThePillow(4, 5);
        assertEquals(passed, 2);
    }

    public int passThePillow(int n, int time) {
        int a = time / (n - 1);
        int b = time % (n - 1);
        if (a == 0) {
            return time + 1;
        } else {
            return a % 2 == 0 ? b + 1 : n - b;
        }
    }
}
