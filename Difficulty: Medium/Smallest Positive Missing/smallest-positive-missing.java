class Solution {
    public int missingNumber(int[] arr) {
        // code here
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > 0) hs.add(arr[i]);
        }
        int ans = 1;
        while(true){
            if(hs.contains(ans)){
                ans++;
                continue;
            }else{
                return ans;
            }
        }
    }
}
