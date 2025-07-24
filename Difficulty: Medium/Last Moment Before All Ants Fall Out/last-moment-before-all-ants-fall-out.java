class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        // code here
        int l = 0;
        for(int i : left){
            l = Math.max(l, i);
        }
        int r = 0;
        for(int i : right){
            r = Math.max(r,n - i);
        }
        return Math.max(r,l);
    }
}