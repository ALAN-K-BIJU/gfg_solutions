class Solution {
    public String longestString(String[] arr) {
        // code here
        ArrayList<String> ls = new ArrayList<>();
        for(String str : arr) ls.add(str);
        Arrays.sort(arr, (a, b) -> { if(a.length() != b.length()) return b.length() - a.length(); else return a.compareTo(b);});
        for(String str : arr){
            int c = 0;
            for(int i = 1; i < str.length(); i++){
                if(!ls.contains(str.substring(0, i))) break;
                else c++;
            }
            if(c == str.length() - 1) return str;
        }
        return "";
    }
}
