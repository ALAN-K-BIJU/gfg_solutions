class Solution {
    public int subarraySum(int[] arr) {
        // code here
        int sum = 0, n = arr.length;
        for(int i = 0; i < n; i++){
            sum += (i+1)*(n - i)*arr[i];
        }
        return sum;
    }
}
