
class Solution {
    public long subarrayXor(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>(); int xor = 0; 
        long count = 0;
        for (int num : arr) {
            xor ^= num;
            if (xor == k) count++;
            count += map.getOrDefault(xor ^ k, 0);
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}