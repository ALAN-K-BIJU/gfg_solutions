import java.util.ArrayList;

class Solution {
    boolean graphColoring(int v, int[][] edges, int m) {
        // If m is 1, the graph can only be colored if it has no edges
        if (m == 1 && v > 1) {
            return edges.length == 0;
        }

        int[] color = new int[v];
        ArrayList<Integer>[] graph = new ArrayList[v];
        for (int i = 0; i < v; i++) {
            graph[i] = new ArrayList<>();
        }

        // Build the adjacency list from the edges array
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            graph[src].add(dest);
            graph[dest].add(src); // Since the graph is undirected
        }

        return solve(0, graph, color, v, m);
    }

    private boolean solve(int node, ArrayList<Integer>[] graph, int[] color, int v, int m) {
        if (node == v) {
            return true; // All nodes colored successfully
        }

        for (int c = 1; c <= m; c++) {
            if (isSafe(node, graph, color, c)) {
                color[node] = c;
                if (solve(node + 1, graph, color, v, m)) {
                    return true;
                }
                color[node] = 0; // Backtrack
            }
        }
        return false; // No valid color found for this node
    }

    private boolean isSafe(int node, ArrayList<Integer>[] graph, int[] color, int c) {
        for (int neighbor : graph[node]) {
            if (color[neighbor] == c) {
                return false; // Neighbor has the same color
            }
        }
        return true; // Safe to color
    }
}