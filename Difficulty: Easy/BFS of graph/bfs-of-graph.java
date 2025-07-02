class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[adj.size()];
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()){
            int node = queue.poll();
            ans.add(node);
            for(int neighbor : adj.get(node)){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
        return ans;
    }
}