// User function Template for Java

class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        // code here
        List<Integer> ans = new ArrayList<Integer>();
        if(N==1 && K==1){
            ans.add(A[0]+B[0]);
            return ans;
        }
        Arrays.sort(A);
        Arrays.sort(B);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> b[0] - a[0]);
        for(int i = N-1; i>=0; i--){
            pq.offer(new int[]{A[N-1]+B[i], N-1, i});
        }
        while(K-- > 0){
            int[] cur = pq.poll();
            ans.add(cur[0]);
            if(cur[1] > 0){
                pq.offer(new int[]{A[cur[1] - 1]+B[cur[2]], cur[1] - 1, cur[2]});
            }
        }
        return ans;
    }
}
