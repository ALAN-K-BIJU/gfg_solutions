class Solution {
    // Function to find number of strongly connected components in the graph.
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        // code here
        int V = adj.size();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!visited[i]) dfs(adj, i, visited, stack);
        }
        ArrayList<ArrayList<Integer>> transpose = new ArrayList<>();
        for(int i = 0; i < V; i++){
            transpose.add(new ArrayList<>());
        }
        for(int i = 0; i < V; i++) for(int neighbor : adj.get(i)) transpose.get(neighbor).add(i);
        Arrays.fill(visited, false);
        int sccCount = 0;
        while(!stack.isEmpty()){
            int node = stack.pop();
            if(!visited[node]){
                sccDfs(transpose, node, visited);
                sccCount++;
            }
        }
        return sccCount;
    }
    private void dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited, Stack<Integer> stack){
        visited[node] = true;
        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]) dfs(adj, neighbor, visited, stack);
        }
        stack.push(node);
    }
    private void sccDfs(ArrayList<ArrayList<Integer>> transpose, int node, boolean[] visited){
        visited[node] = true;
        for(int neighbor : transpose.get(node)){
            if(!visited[neighbor]) sccDfs(transpose, neighbor, visited);
        }
    }
}