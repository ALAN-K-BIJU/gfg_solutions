

// User function Template for Java

class Solution {
    public int celebrity(int[][] mat) {
        int n = mat.length;
        int potentialCelebrity = 0;
        for (int i = 1; i < n; ++i) {
            if (mat[potentialCelebrity][i] == 1) {
                potentialCelebrity = i;
            }
        }
        for (int i = 0; i < n; ++i) {
            if (i != potentialCelebrity && (mat[potentialCelebrity][i] == 1 || mat[i][potentialCelebrity] == 0)) {
                return -1;
            }
        }

        return potentialCelebrity;
    }
}