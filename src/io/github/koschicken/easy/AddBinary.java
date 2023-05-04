package io.github.koschicken.easy;

import java.util.Arrays;

public class AddBinary {

    public static void main(String[] args) {
        String a = "110010";
        String b = "10111";
//        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
//        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
        String s = addBinary(a, b);
        System.out.println(s);
    }

    private static String addBinary(String a, String b) {
        int length = Math.max(a.length(), b.length());
        int divide = length - Math.min(a.length(), b.length());
        if (a.length() < length) {
            a = dealShortStr(a, divide);
        }
        if (b.length() < length) {
            b = dealShortStr(b, divide);
        }
        char[] result = new char[length + 1];
        int carry = 0;
        for (int i = length - 1; i >= 0; i--) {
            int aInt = Integer.parseInt(String.valueOf(a.charAt(i)));
            int bInt = Integer.parseInt(String.valueOf(b.charAt(i)));
            if (carry == 0) {
                if (aInt + bInt == 2) {
                    carry = 1;
                    result[i + 1] = '0';
                } else if (aInt + bInt == 1) {
                    result[i + 1] = '1';
                } else {
                    result[i + 1] = '0';
                }
            } else {
                if (aInt + bInt + carry == 3) {
                    result[i + 1] = '1';
                } else if (aInt + bInt + carry == 2) {
                    result[i + 1] = '0';
                } else {
                    carry = 0;
                    result[i + 1] = '1';
                }
            }
        }
        if (carry == 0) {
            result = Arrays.copyOfRange(result, 1, result.length);
        } else {
            result[0] = '1';
        }
        return new String(result);
    }

    private static String dealShortStr(String str, int length) {
        char[] chars = new char[length];
        Arrays.fill(chars, '0');
        return new String(chars).concat(str);
    }

    /**
     * 很长的字符串是无法转换的
     */
    private static String notAnswer(String a, String b) {
        Integer aInt = Integer.valueOf(a, 2);
        Integer bInt = Integer.valueOf(b, 2);
        return Integer.toBinaryString(aInt + bInt);
    }
}
