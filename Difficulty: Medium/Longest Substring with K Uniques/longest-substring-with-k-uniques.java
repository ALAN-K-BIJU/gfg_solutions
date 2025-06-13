// User function Template for Java

class Solution {
    public int longestkSubstr(String s, int k) {
        // code here
        HashMap<Character, Integer> map = new HashMap<>();
        int max = -1;
        int i = 0, j = 0;
        while(i < s.length() && j < s.length()){
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            if(map.size() == k){
                max = Math.max(max, j - i + 1);
            }else if(map.size() > k){
                while(map.size() > k){
                    int val = map.get(s.charAt(i));
                    val--;
                    if(val > 0){
                        map.put(s.charAt(i), val);
                    }else{
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }
}