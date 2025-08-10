class Solution {
    public int countPS(String s) {
        // code here
        int count = 0;
        int n = s.length();
        for(int center = 0;center<n;center++){
            int l = center; int r = center + 1;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                count++;
                l--;
                r++;
            }
            l = center-1;
            r = center+1;
            while(l>=0 && r<n && s.charAt(l) == s.charAt(r)){
                count++;
                l--;
                r++;
            }
        }
        return count;
    }
}