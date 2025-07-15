class Solution {
    public static int countNumbers(int n) {
        // code here
        int count = 0;
        for(int p = 2; ;p++){
            long num = (long) Math.pow(p,8);
            if(num > n){
                break;
            }
            if(isPrime(p)){
                count++;
            }
        }
        List<Integer> primes = sieve((int) Math.sqrt(n) + 1);
        int size = primes.size();
        for(int i = 0; i < size; i++){
            for(int j = i + 1; j < size; j++){
                long p = primes.get(i);
                long q = primes.get(j);
                long product = p*p*q*q;
                if(product > n){
                    break;
                }
                count++;
            }
        }
        return count;
    }
    private static boolean isPrime(int num){
        if(num <= 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        for(int i = 3; i*i <= num; i+=2){
            if(num%i == 0) return false;
        }
        return true;
    }
    private static List<Integer> sieve(int limit){
        boolean[] isPrime = new boolean[limit + 1];
        for(int i = 2; i <= limit; i++){
            isPrime[i] = true;
        }
        for(int p = 2; p*p <= limit; p++){
            if(isPrime[p]){
                for(int i = p*p; i <= limit; i+=p) isPrime[i] = false;
            }
        }
        List<Integer> primes = new ArrayList<>();
        for(int i = 2; i <= limit; i++){
            if(isPrime[i]) primes.add(i);
        }
        return primes;
    }
}