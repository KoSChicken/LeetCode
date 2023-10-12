package io.github.koschicken.easy;

/**
 * <a href="https://leetcode.cn/problems/excel-sheet-column-title/description/">168. Excel表列名称</a>
 * <a href="https://leetcode.cn/problems/excel-sheet-column-number/description/">171. Excel表列序号</a>
 */
public class ExcelColumn {

    public static void main(String[] args) {
        System.out.println(convertToTitle(2147483647));
        System.out.println(titleToNumber("FXSHRXW"));
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

    private static int titleToNumber(String columnTitle) {
        int column = 0;
        int length = columnTitle.length();
        for (int i = 0; i < length; i++) {
            char ch = columnTitle.charAt(i);
            column = column * 26 + ch - '@';
        }
        return column;
    }
}
