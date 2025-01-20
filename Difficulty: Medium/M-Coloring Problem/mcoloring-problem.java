//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());      // Number of vertices
            String[] arrInput = br.readLine().trim().split(" "); // Input for edges

            List<int[]> edges = new ArrayList<>();
            for (int i = 0; i < arrInput.length; i += 2) {
                int u = Integer.parseInt(arrInput[i]);
                int v = Integer.parseInt(arrInput[i + 1]);
                edges.add(new int[] {u, v});
            }

            int m = Integer.parseInt(br.readLine().trim()); // Number of colors

            Solution sol = new Solution();
            System.out.println(sol.graphColoring(n, edges, m) ? "true" : "false");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {
    boolean graphColoring(int v, List<int[]> edges, int m) {
        // code here
        if(m == 1 && v > 1) return false;
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
        int[] col = new int[v];
        boolean[] vis = new boolean[v];
        ArrayList<Integer>[] graph = (ArrayList<Integer>[])new ArrayList[v];
        
        for(int i = 0; i < v; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int[] edge : edges){
            int src = edge[0];
            int dest = edge[1];
            
            graph[src].add(dest);
            graph[dest].add(src);
        }
        
        q.add(0);
        col[0] = 1;
        
        while(!q.isEmpty()){
            int src = q.remove();
            int col2 = col[src];
            vis[src] = true;
            if(col2 == 0){
               ArrayList<Integer> list = hm.get(src);
               
               for(int i = 1; i <= m; i++){
                  if(!list.contains(i)){
                      col[src] = i;
                      break;
                  }
               }
               col2 = col[src];
               if(col2 == 0) return false;
            }
            
            for(int i = 0; i < graph[src].size(); i++){
                int dest = graph[src].get(i);
                ArrayList<Integer> list;
                
                if(hm.containsKey(dest)){
                   list = hm.get(dest);
                }
                else{
                   list = new ArrayList<>();
                }
                if(!vis[dest]){
                list.add(col2);
                hm.put(dest,list);}
                if(!vis[dest])
                q.add(dest);
            }
        }
        
        return true;
    }
}    