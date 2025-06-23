class Solution {
    public static int firstRepeated(int[] arr) {
        // code here
        int res = -1;
        int ans = Integer.MAX_VALUE;
        HashMap<Integer, Integer> set = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(!set.containsKey(arr[i])) set.put(arr[i], i+1);
            else{
                res = set.get(arr[i]);
                ans = Math.min(res, ans);
            }
        }
        if(res == -1) ans = -1;
        return ans;
    }
}
