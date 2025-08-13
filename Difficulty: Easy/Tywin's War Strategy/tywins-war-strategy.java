class Solution {
    public int minSoldiers(int[] arr, int k) {
        // code here
        int[] rem = new int[arr.length];
        int zeroes = 0;
        for(int i = 0; i < arr.length; i++){
            rem[i] = arr[i] % k;
            if(rem[i] == 0) continue;
            else rem[i] = k - rem[i];
        }
        Arrays.sort(rem);
        int sum = 0;
        
        for(int i = 0; i < (arr.length+1)/2; i++){
            sum += rem[i];
        }
        return sum;
    }
}