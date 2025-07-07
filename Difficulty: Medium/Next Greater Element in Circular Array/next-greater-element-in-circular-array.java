class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        Stack<Integer> st = new Stack<>(); 
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        for(int i = (2*n) - 1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= arr[i % n]) st.pop();
            if(i < n){
                if(st.isEmpty()) res.add(-1);
                else res.add(st.peek());
            }
            st.push(arr[i % n]);
        }
        Collections.reverse(res);
        return res;
    }
}