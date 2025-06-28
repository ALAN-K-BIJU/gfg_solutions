class Solution {
    public static ArrayList<Integer> countLessEq(int a[], int b[]) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Arrays.sort(b);
        for(int i = 0; i < a.length; i++){
            int tmp = binarySearch(b, a[i], 0, b.length - 1);
            res.add(tmp < 0 ? 0 : tmp + 1);
        }
        return res;
    }
    static int binarySearch(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = (end - start)/2 + start;
            if(arr[mid] == target) return binarySearch(arr, target, mid+1, end);
            if(arr[mid] < target) start = mid+1;
            else end = mid - 1;
        }
        return end;
    }
}