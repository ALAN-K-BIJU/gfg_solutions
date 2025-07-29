class Solution {
    public ArrayList<Integer> asciirange(String s) {
        // code here
        Map<Character, int[]> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!map.containsKey(ch)) map.put(ch, new int[]{i, i});
            else map.get(ch)[1] = i; 
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (Map.Entry<Character, int[]> entry : map.entrySet()) {
            int start = entry.getValue()[0];
            int end = entry.getValue()[1];
            if (end - start <= 1) continue;
            int sum = 0;
            for (int i = start + 1; i < end; i++) {
                sum += s.charAt(i);
            }
            if (sum > 0) result.add(sum);
        }
        return result;
    }
}