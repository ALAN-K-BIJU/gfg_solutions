// User function Template for Java

class Solution {
    public static List<String> generateBinaryStrings(int n) {
        // code here
        List<String> ls = new ArrayList<>();
        generateHelper("",n,ls);
        return ls;
    }
    public static void generateHelper(String current, int n, List<String> ls){
        if(current.length() == n){
            ls.add(current);
            return;
        }
        generateHelper(current+"0",n,ls);
        if(current.isEmpty() || current.charAt(current.length() - 1) != '1'){
            generateHelper(current+"1",n,ls);
        }
    }
}
