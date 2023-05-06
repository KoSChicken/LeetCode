package io.github.koschicken.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = triangle(3);
        triangle.forEach(System.out::println);
        System.out.println(triangleRow(3));
    }

    private static List<List<Integer>> triangle(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> rowList = new ArrayList<>();
            for (int n = 0; n < row + 1; n++) {
                if (n == 0 || n == row) {
                    rowList.add(1);
                } else {
                    rowList.add(result.get(row - 1).get(n - 1) + result.get(row - 1).get(n));
                }
            }
            result.add(rowList);
        }
        return result;
    }

    private static List<Integer> triangleRow(int rowIndex) {
        List<List<Integer>> result = new ArrayList<>();
        for (int row = 0; row <= rowIndex; row++) {
            List<Integer> rowList = new ArrayList<>();
            for (int n = 0; n < row + 1; n++) {
                if (n == 0 || n == row) {
                    rowList.add(1);
                } else {
                    rowList.add(result.get(row - 1).get(n - 1) + result.get(row - 1).get(n));
                }
            }
            result.add(rowList);
        }
        return result.get(rowIndex);
    }
}
