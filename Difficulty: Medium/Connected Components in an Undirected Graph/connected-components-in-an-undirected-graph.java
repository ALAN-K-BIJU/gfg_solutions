
class Solution {
    public ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        DSU dsu = new DSU(V);
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            dsu.unionBySize(u, v);
        }
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < V; i++){
            int parent = dsu.findPar(i);
            map.computeIfAbsent(parent, k -> new ArrayList<>()).add(i);
        }
        return new ArrayList<>(map.values());
    }
}
class DSU{
    int[] par;
    int[] rank;
    int[] size;
    int n;
    DSU(int n){
        this.n = n;
        this.par = new int[n];
        this.rank = new int[n];
        this.size = new int[n];
        for(int i = 0; i < n; i++){
            par[i] = i;
            rank[i] = 0;
            size[i] = i;
        }
    }
    int findPar(int node){
        if(node == par[node]) return node;
        return par[node] = findPar(par[node]);
    }
    void unionByRank(int u, int v){
        int pu = findPar(u);
        int pv = findPar(v);
        if(rank[pu] < rank[pv]){
            par[pu] = pv;
        }
        else if(rank[pv] < rank[pu]){
            par[pv] = pu;
        }else{
            par[pu] = pv;
            rank[pv] += 1;
        }
    }
    void unionBySize(int u, int v){
        int pu = findPar(u);
        int pv = findPar(v);
        if(size[pu] < size[pv]){
            par[pu] = pv;
            size[pv] += size[pu];
        }else{
            par[pv] = pu;
            size[pu] += size[pv];
        }
    }
}