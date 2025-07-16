class Solution {
    public int maxKPower(int n, int k) {
        // code here
        Map<Integer, Integer> pf = primeFactorize(k);
        int result = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> entry : pf.entrySet()){
            int prime = entry.getKey();
            int exponent = entry.getValue();
            int count = countPrimeInFactorial(n, prime);
            result = Math.min(result, count / exponent);
        }
        return result;
    }
    private Map<Integer, Integer> primeFactorize(int k){
        Map<Integer, Integer> pf = new HashMap<>();
        while(k % 2 == 0){
            pf.put(2, pf.getOrDefault(2, 0) + 1);
            k/= 2;
        }
        for(int i = 3; i*i <= k; i+=2){
            while(k%i == 0){
                pf.put(i, pf.getOrDefault(i, 0) + 1);
                k /= i;
            }
        }
        if(k > 2){
            pf.put(k, pf.getOrDefault(k, 0) + 1);
        }
        return pf;
    }
    private int countPrimeInFactorial(int n, int prime){
        int count = 0;
        for(long power = prime; power <= n; power*= prime) count+= n/ power;
        return count;
    }
}