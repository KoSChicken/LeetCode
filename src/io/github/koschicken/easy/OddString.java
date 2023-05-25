package io.github.koschicken.easy;

public class OddString {

    public static void main(String[] args) {
        System.out.println(oddString(new String[]{"poo", "baa", "onn", "ddd"}));
    }

    public static String oddString(String[] words) {
        String s1 = convert(words[0]);
        String s2 = convert(words[1]);
        for (int i = 2; i < words.length; i++) {
            String word = words[i];
            String str = convert(word);
            if (s1.equals(s2)) {
                if (!str.equals(s1)) {
                    return word;
                }
            } else {
                if (s1.equals(str)) {
                    return words[1];
                } else {
                    return words[0];
                }
            }
        }
        return null;
    }

    private static String convert(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(length - 1);
        char divide = (char) (str.charAt(0) - 'a');
        for (int i = 0; i < length; i++) {
            sb.append(str.charAt(i) - divide);
        }
        return sb.toString();
    }
}
