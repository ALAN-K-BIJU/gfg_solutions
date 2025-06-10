// User function Template for Java
class Solution {
    public static int aggressiveCows(int[] stalls, int k) {
        // code here
        Arrays.sort(stalls);
        int n = stalls.length;
        int s = 1;
        int e = stalls[n-1] - stalls[0];
        int ans = -1;
        while(s <= e){
            int mid = s + (e-s)/2;
            int pos=stalls[0];
            int count = 1;
            for(int i = 1; i< n;i++){
                if(pos+mid <= stalls[i]){
                    count++;
                    pos= stalls[i];
                }
            }
            if(count < k){
                e = mid - 1;
            }else{
                ans = mid;
                s = mid+1;
            }
        }
        return ans;
    }
}