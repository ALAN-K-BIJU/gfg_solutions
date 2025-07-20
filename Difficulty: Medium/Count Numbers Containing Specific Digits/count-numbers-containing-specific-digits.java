class Solution {
    public int countValid(int n, int[] arr) {
        // code here
        long total = 9*(long) Math.pow(10, n - 1);
        HashSet<Integer> forbiddenDigits = new HashSet<>();
        for(int digit : arr) forbiddenDigits.add(digit);
        int ac = 10 - forbiddenDigits.size();
        long invalidNumbers;
        if(forbiddenDigits.contains(0)) invalidNumbers = (long) Math.pow(ac, n);
        else invalidNumbers = (long) (ac - 1)*(long)(Math.pow(ac, n - 1));
        long res = total - invalidNumbers;
        return(int) res;
    }
}