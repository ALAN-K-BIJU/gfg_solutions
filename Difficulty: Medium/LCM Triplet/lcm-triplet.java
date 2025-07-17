class Solution {
    int lcmTriplets(int n) {
        // code here
        int ans = 0;
        if(n < 3) ans = n;
        else if(n%2 != 0) ans = n*(n-1)*(n-2);
        else if(n %3 != 0) ans = n*(n-1)*(n-3);
        else ans = (n - 1)*(n - 2)* (n - 3);
        return ans;
    }
}