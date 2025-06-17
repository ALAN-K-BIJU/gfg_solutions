// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<String> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    StringBuilder shape = new StringBuilder();
                    dfs(i, j, visited, grid, shape, "O");
                    set.add(shape.toString());
                }
            }
        }
        return set.size();
    }
    public void dfs(int r, int c, boolean[][] visited, int[][] grid, StringBuilder shape, String direction){
        visited[r][c] = true;
        shape.append(direction);
        //System.out.println(shape);
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, -1, 0, 1};
        String[] dir = {"U","L","D","R"};
        for(int k = 0; k < 4; k++){
            int row = r + drow[k];
            int col = c + dcol[k];
            if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && !visited[row][col] && grid[row][col] == 1){
                dfs(row, col, visited, grid, shape, dir[k]);
            }
        }
        shape.append("B");
    }
}
