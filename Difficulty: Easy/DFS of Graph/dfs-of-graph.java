class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        dfs(0, adj, visited, ans);
        return ans;
    }
    private void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans){
        visited[node] = true;
        ans.add(node);
        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor, adj, visited, ans);
            }
        }
    }
}