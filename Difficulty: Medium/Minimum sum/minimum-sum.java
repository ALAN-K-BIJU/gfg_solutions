class Solution {
    String minSum(int[] arr) {
        Arrays.sort(arr);
       int carry=0,sum=0,t=0;;
       StringBuilder s= new StringBuilder("");
        for(int i=arr.length-1;i>=1;i-=2){
            int temp=arr[i]+arr[i-1]+carry;
            carry=temp/10;
            s.append(String.valueOf(temp%10));
        }
        if(arr.length%2==1) s.append(String.valueOf(arr[0]+carry));
        else s.append(String.valueOf(carry));
        String ans=s.reverse().toString();
        while(t<ans.length()&&ans.charAt(t)=='0') t++;
        return ans.substring(t);
    }
}
