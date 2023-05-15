package io.github.koschicken.easy;

public class HammingWeight {

    public static void main(String[] args) {
        System.out.println(Integer.bitCount(-3));
    }

    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
