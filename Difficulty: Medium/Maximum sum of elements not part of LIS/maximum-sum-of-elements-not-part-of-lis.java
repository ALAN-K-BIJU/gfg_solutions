class Solution {
    public int nonLisMaxSum(int[] arr) {
        // code here
        int n = arr.length;
        int totalSum = 0;
        for(int i = 0; i < n; i++){
           totalSum += arr[i];
        }
        int [][]dp = new int[2][n];
        for(int i = 0; i < n; i++){
           dp[0][i] = 1;
           dp[1][i] = arr[i];
        }
        for(int i = 1; i < n; i++){
           for(int j = 0; j < i; j++){
              if (arr[i] > arr[j]){
                  if (dp[0][i] < dp[0][j] + 1){
                      dp[0][i] = dp[0][j] + 1;
                      dp[1][i] = dp[1][j] + arr[i];
                  }
                  else if (dp[0][i] == dp[0][j] + 1){
                      dp[1][i] = Math.min(dp[1][i], dp[1][j] + arr[i]);
                  }
              }
           }
        }
        int maxm = 0;
        int subtractSum = 0;
        for(int i = 0; i < n; i++){
           if (dp[0][i] > maxm){
               maxm = dp[0][i];
               subtractSum = dp[1][i];
           }
           else if (dp[0][i] == maxm){
               subtractSum = Math.min(subtractSum, dp[1][i]);
           }
        }
        return totalSum - subtractSum;
    }
}