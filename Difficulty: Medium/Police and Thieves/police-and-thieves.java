class Solution {
    public int catchThieves(char[] arr, int k) {
        // code here
        int ans = 0, n = arr.length, pIndex = findNextIndex(arr, -1, n, 'P');
        int tIndex = findNextIndex(arr, -1, n, 'T');
        while(pIndex != -1 && tIndex != -1){
            if(Math.abs(pIndex - tIndex) <= k){
                ans++;
                pIndex = findNextIndex(arr, pIndex, n, 'P');
                tIndex = findNextIndex(arr, tIndex, n, 'T');
            }else if(pIndex < tIndex){
                pIndex = findNextIndex(arr, pIndex, n, 'P');
            }else{
                tIndex = findNextIndex(arr, tIndex, n, 'T');
            }
        }
        return ans;
    }
    int findNextIndex(char[] arr, int curr, int n, int key){
        for(int i = curr + 1; i < n; i++){
            if(arr[i] == key) return i;
        }
        return -1;
    }
}