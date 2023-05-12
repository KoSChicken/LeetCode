package io.github.koschicken.easy;

public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(reverseBits(43261596));
    }

    private static int reverseBits(int n) {
        String binaryString = Integer.toBinaryString(n);
        int i = 0;
        int j = binaryString.length() - 1;
        char[] arr = new char[]{48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48};
        while (i < j) {
            arr[j] = binaryString.charAt(i);
            arr[i] = binaryString.charAt(j);
            i++;
            j--;
        }
        return Integer.parseInt(new String(arr), 2);
    }

    private static String toBits(int n) {
        return Integer.toBinaryString(n);
    }
}
