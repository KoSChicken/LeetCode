package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/evaluate-division/description/">399. 除法求值</a>
 */
public class EvaluateDivision {

    @Test
    void solution() {

        List<List<String>> testEquations1 = new ArrayList<>();
        testEquations1.add(List.of("a", "b"));
        testEquations1.add(List.of("e", "f"));
        testEquations1.add(List.of("b", "e"));
        double[] testValues1 = new double[]{3.4, 1.4, 2.3};
        List<List<String>> testQueries1 = new ArrayList<>();
        testQueries1.add(List.of("b", "a"));
        testQueries1.add(List.of("a", "f"));
        testQueries1.add(List.of("f", "f"));
        testQueries1.add(List.of("e", "e"));
        testQueries1.add(List.of("c", "c"));
        testQueries1.add(List.of("a", "c"));
        testQueries1.add(List.of("f", "e"));
        double[] actual1 = calcEquation(testEquations1, testValues1, testQueries1);
        System.out.println(Arrays.toString(actual1));
        // assertArrayEquals(new double[]{0.29412, 10.948, 1.0, 1.0, -1.0, -1.0, 0.71429}, actual1);

        List<List<String>> testEquations2 = new ArrayList<>();
        testEquations2.add(List.of("a", "b"));
        testEquations2.add(List.of("c", "d"));
        double[] testValues2 = new double[]{1.0, 1.0};
        List<List<String>> testQueries2 = new ArrayList<>();
        testQueries2.add(List.of("a", "c"));
        testQueries2.add(List.of("b", "d"));
        testQueries2.add(List.of("b", "a"));
        testQueries2.add(List.of("d", "c"));
        double[] actual2 = calcEquation(testEquations2, testValues2, testQueries2);
        System.out.println(Arrays.toString(actual2));
        // assertArrayEquals(new double[]{-1.0, -1.0, 1.0, 1.0}, actual2);

        List<List<String>> testEquations3 = new ArrayList<>();
        testEquations3.add(List.of("a", "b"));
        testEquations3.add(List.of("b", "c"));
        double[] testValues3 = new double[]{2.0, 3.0};
        List<List<String>> testQueries3 = new ArrayList<>();
        testQueries3.add(List.of("a", "c"));
        testQueries3.add(List.of("b", "a"));
        testQueries3.add(List.of("a", "e"));
        testQueries3.add(List.of("a", "a"));
        testQueries3.add(List.of("x", "x"));
        double[] actual3 = calcEquation(testEquations3, testValues3, testQueries3);
        System.out.println(Arrays.toString(actual3));
        // assertArrayEquals(new double[]{6.0, 0.5, -1.0, 1.0, -1.0}, actual3);

        List<List<String>> testEquations4 = new ArrayList<>();
        testEquations4.add(List.of("x1", "x2"));
        testEquations4.add(List.of("x2", "x3"));
        testEquations4.add(List.of("x3", "x4"));
        testEquations4.add(List.of("x4", "x5"));
        double[] testValues4 = new double[]{3.0, 4.0, 5.0, 6.0};
        List<List<String>> testQueries4 = new ArrayList<>();
        testQueries4.add(List.of("x1", "x5"));
        testQueries4.add(List.of("x5", "x2"));
        testQueries4.add(List.of("x2", "x4"));
        testQueries4.add(List.of("x2", "x2"));
        testQueries4.add(List.of("x2", "x9"));
        testQueries4.add(List.of("x9", "x9"));
        double[] actual4 = calcEquation(testEquations4, testValues4, testQueries4);
        System.out.println(Arrays.toString(actual4));
        // assertArrayEquals(new double[]{360.0, 0.00833, 20.0, 1.0, -1.0, -1.0}, actual4);
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        // 建图
        Graph graph = new Graph();
        for (int i = 0; i < n; i++) {
            List<String> equation = equations.get(i);
            graph.addVertex(equation.get(0));
            graph.addVertex(equation.get(1));
            graph.addEdge(equation.get(0), equation.get(1), values[i]);
        }
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            Set<String> visited = new HashSet<>();
            List<String> query = queries.get(i);
            String from = query.get(0);
            String to = query.get(1);
            if (graph.notContains(from) || graph.notContains(to)) {
                ans[i] = -1.0;
            } else if (from.equals(to)) {
                ans[i] = 1.0;
            } else {
                ans[i] = dfs(graph, visited, from, to);
            }
        }
        return ans;
    }

    private double dfs(Graph graph, Set<String> visited, String from, String to) {
        double res = 1.0;
        List<Edge> edges = graph.getEdges(from);
        for (Edge edge : edges) {
            double value = edge.value();
            visited.add(from);
            if (edge.to().equals(to)) {
                return res * value;
            }
            if (!visited.contains(edge.to())) {
                visited.add(edge.to());
                double dfs = dfs(graph, visited, edge.to(), to);
                if (dfs != -1) {
                    return dfs * value;
                }
            }
        }
        return -1;
    }

    static class Graph {

        private final Map<String, List<Edge>> adjVertices;

        Graph() {
            adjVertices = new HashMap<>();
        }

        public void addVertex(String label) {
            adjVertices.putIfAbsent(label, new ArrayList<>());
        }

        public void addEdge(String v1, String v2, double value) {
            adjVertices.get(v1).add(new Edge(v2, value));
            adjVertices.get(v2).add(new Edge(v1, 1 / value));
        }

        public List<Edge> getEdges(String vertex) {
            return adjVertices.get(vertex);
        }

        public boolean notContains(String vertex) {
            return !adjVertices.containsKey(vertex);
        }
    }

    record Edge(String to, double value) {

    }
}
