package io.github.koschicken.easy;

public class ExcelColumn {

    public static void main(String[] args) {
        System.out.println(convertToTitle(2147483647));
        System.out.println(convertToNumber("FXSHRXW"));
    }

    private static String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }

    private static int convertToNumber(String columnTitle) {
        int column = 0;
        int length = columnTitle.length();
        for (int i = 0; i < length; i++) {
            char ch = columnTitle.charAt(i);
            column = column * 26 + ch - '@';
        }
        return column;
    }
}
