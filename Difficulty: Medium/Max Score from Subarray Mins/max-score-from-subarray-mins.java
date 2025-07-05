class Solution {
    public int maxSum(int arr[]) {
        // code here
        int maxSum = 0;
        int sum = 0;
        for(int i = 0; i < arr.length - 1; i++){
            sum = arr[i] + arr[i+1];
            if(sum > maxSum){
                maxSum = sum;
            }
        }
        return maxSum;
    }
}