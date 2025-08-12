class Solution {
    public ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        // code here
        int n=prices.length;
        int i=0,j=n-1;
        Arrays.sort(prices);
        ArrayList<Integer>res=new ArrayList<>();
        int s=0;
        while(i<=j){
            s+=prices[i];
            i++;
            for(int a=0;a<k;a++){
                j--;
            }
        }
        res.add(s);
        s=0;i=0;j=n-1;
        while(i<=j){
            s+=prices[j];
            j--;
            for(int a=0;a<k;a++){
                i++;
            }
        }
        res.add(s);
        return res;
    }
}
