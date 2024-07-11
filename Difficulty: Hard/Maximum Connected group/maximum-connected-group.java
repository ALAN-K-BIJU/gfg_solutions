//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    private int n;
    private int[][] grid;
    private boolean[][] visited;
    private int[] parent;
    private int[] size;

    // Helper arrays to facilitate moving in four directions
    private static final int[] dRow = { -1, 1, 0, 0 };
    private static final int[] dCol = { 0, 0, -1, 1 };

    public int MaxConnection(int[][] grid) {
        this.grid = grid;
        this.n = grid.length;
        this.visited = new boolean[n][n];
        this.parent = new int[n * n];
        this.size = new int[n * n];

        // Initialize the parent and size arrays for Union-Find
        for (int i = 0; i < n * n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        // Perform DFS to mark each connected component
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        int maxSize = 0;
        // Calculate the current maximum connected component size
        for (int i = 0; i < n * n; i++) {
            if (parent[i] == i) {
                maxSize = Math.max(maxSize, size[i]);
            }
        }

        // Try changing each 0 to 1 and calculate the new maximum connected component size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> uniqueComponents = new HashSet<>();
                    int newSize = 1; // Size of the new component if this cell is changed to 1

                    for (int d = 0; d < 4; d++) {
                        int ni = i + dRow[d];
                        int nj = j + dCol[d];

                        if (isValid(ni, nj) && grid[ni][nj] == 1) {
                            int componentRoot = find(ni * n + nj);
                            if (uniqueComponents.add(componentRoot)) {
                                newSize += size[componentRoot];
                            }
                        }
                    }

                    maxSize = Math.max(maxSize, newSize);
                }
            }
        }

        return maxSize;
    }

    private void dfs(int row, int col) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{ row, col });
        visited[row][col] = true;
        int currentIndex = row * n + col;

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int r = cell[0], c = cell[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dRow[d];
                int nc = c + dCol[d];

                if (isValid(nr, nc) && grid[nr][nc] == 1 && !visited[nr][nc]) {
                    int newIndex = nr * n + nc;
                    union(currentIndex, newIndex);
                    stack.push(new int[]{ nr, nc });
                    visited[nr][nc] = true;
                }
            }
        }
    }

    private boolean isValid(int row, int col) {
        return row >= 0 && row < n && col >= 0 && col < n;
    }

    private int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        if (rootI != rootJ) {
            if (size[rootI] >= size[rootJ]) {
                parent[rootJ] = rootI;
                size[rootI] += size[rootJ];
            } else {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            }
        }
    }
}
