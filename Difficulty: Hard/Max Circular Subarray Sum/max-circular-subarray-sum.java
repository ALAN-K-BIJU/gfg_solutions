

class Solution {
    public int maxCircularSum(int arr[]) {
        // Your code here
        int maxKadane = kadane(arr);
        int totalsum = 0;
        for(int i = 0; i < arr.length; i++){
            totalsum += arr[i];
            arr[i] = -arr[i];
        }
        int minKadane = kadane(arr);
        int maxcircular = totalsum + minKadane;
        return (maxcircular == 0) ? maxKadane : Math.max(maxKadane, maxcircular);
    }
    public int kadane(int[] nums){
        int max = 0;
        int cur = Integer.MIN_VALUE;
        for(int num : nums){
            max = Math.max(num, max + num);
            cur = Math.max(cur, max);
        }
        return cur;
    }
}
