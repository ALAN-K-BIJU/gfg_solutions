class Solution {
    public int sumSubMins(int[] arr) {
        // code here
        int mod = 1_000_000_007;
        int n = arr.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            prev[i] = st.isEmpty() ? -1 : st.peek(); 
            st.push(i);
        }
        st.clear();
        for(int i = n - 1; i >= 0; i--){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        long sum = 0;
        for(int i = 0; i < n; i++){
            long count = (i - prev[i])*(next[i] - i) % mod;
            sum = (sum + count * arr[i]) % mod;
        }
        return (int)sum;
    }
}
