class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        int[] disc = new int[V];
        int[] low = new int[V];
        int[] parent = new int[V];
        boolean[] visited = new boolean[V];
        boolean[] ap = new boolean[V];
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.fill(disc, -1);
        Arrays.fill(low, -1);
        Arrays.fill(parent, -1);
        for(int i = 0; i < V; i++){
            if(!visited[i]){
                dfs(i, adj, disc, low, parent, visited, ap, 0);
            }
        }
        for(int i = 0; i < V; i++){
            if(ap[i]) result.add(i);
        }
        if(result.isEmpty()) result.add(-1);
        return result;
    }
    private void dfs(int u, ArrayList<ArrayList<Integer>> adj, int[] disc, int[] low, int[] parent, boolean[] visited, boolean[] ap, int time){
        visited[u] = true;
        disc[u] = low[u] = ++time;
        int children = 0;
        for(int v : adj.get(u)){
            if(!visited[v]){
                parent[v] = u;
                children++;
                dfs(v, adj, disc, low, parent, visited, ap, time);
                low[u] = Math.min(low[u], low[v]);
                if(parent[u] == -1 && children > 1) ap[u] = true;
                if(parent[u] != -1 && low[v] >= disc[u]) ap[u] = true;
            }else if(v != parent[u]){
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}