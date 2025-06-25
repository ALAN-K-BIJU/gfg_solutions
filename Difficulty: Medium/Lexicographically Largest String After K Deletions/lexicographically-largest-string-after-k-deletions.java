class Solution {
    public static String maxSubseq(String s, int k) {
        // code here
        if(s == null || s.length() == 0 || k < 0) return "";
        if(k == 0) return s;
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char ch : s.toCharArray()){
            while(!stack.isEmpty() && stack.peek() < ch && k > 0){
                stack.pop();
                k--;
            }
            stack.push(ch);
        }
        while(!stack.isEmpty() && k-- > 0) stack.pop();
        while(!stack.isEmpty()) result.append(stack.pop());
        return result.reverse().toString();
    }
}