class Solution {
    public static int balanceSums(int[][] mat) {
        // code here
        int n = mat.length;
        int[] rowSum = new int[n];
        int[] colSum = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                rowSum[i] += mat[i][j];
                colSum[j] += mat[i][j];
            }
        }
        int maxSum = 0;
        for(int i = 0; i < n; i++){
            maxSum = Math.max(maxSum, rowSum[i]);
            maxSum = Math.max(maxSum, colSum[i]);
        }
        int ops = 0;
        for(int i = 0; i < n; i++){
            ops += maxSum - rowSum[i];
        }
        return ops;
    }
}