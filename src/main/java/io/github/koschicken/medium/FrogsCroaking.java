package io.github.koschicken.medium;

public class FrogsCroaking {

    private static final char[] PREVIOUS = new char['s'];

    static {
        char[] s = "croakc".toCharArray();
        for (int i = 1; i < s.length; i++) {
            PREVIOUS[s[i]] = s[i - 1];
            System.out.println(PREVIOUS);
        }
    }

    private static int minNumberOfFrogs(String croakOfFrogs) {
        int[] count = new int['s'];
        for (char ch : croakOfFrogs.toCharArray()) {
            char previous = PREVIOUS[ch];
            if (count[previous] > 0) {
                count[previous]--;
            } else if (ch != 'c') {
                return -1;
            }
            count[ch]++;
        }
        if (count['c'] > 0 || count['r'] > 0 || count['o'] > 0 || count['a'] > 0) {
            return -1;
        }
        return count['k'];
    }

    public static void main(String[] args) {
        System.out.println(minNumberOfFrogs("croakcrook"));
    }
}
