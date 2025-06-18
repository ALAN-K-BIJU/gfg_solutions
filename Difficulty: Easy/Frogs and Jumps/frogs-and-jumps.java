// User function Template for Java

class Solution {
    public int unvisitedLeaves(int N, int leaves, int frogs[]) {
        // Code here
        int unVisited = 0;
        boolean[] visit = new boolean[leaves + 1];
        for(int i = 0; i < N; i++){
            int currPos = frogs[i];
            if(currPos <= leaves && ! visit[currPos]){
                for(int j = currPos; j <= leaves; j+= currPos){
                    visit[j] = true;
                }
            }
        }
        for(int i = 1; i <= leaves; i++){
            if(!visit[i]) unVisited++;
        }
        return unVisited;
    }
}
