class Solution {
    public boolean isPalinSent(String s) {
        // code here
        String cleanString = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return isPalin(cleanString);
    }
    private boolean isPalin(String s){
        int i = 0 , j = s.length()-1;
        while(i<=j)
        {
            if(s.charAt(i++) != s.charAt(j--))
            return false;
        }
        return true;
    }
}