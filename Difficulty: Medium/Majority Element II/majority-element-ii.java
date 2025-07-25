

class Solution {
    // Function to find the majority elements in the array
    public ArrayList<Integer> findMajority(int[] nums) {
        // Your code goes here.
        if(nums.length == 1) return new ArrayList<>(List.of(nums[0]));
        int majority1 = 0;
        int majority2 = 0;
        int count1 = 0;
        int count2 = 0;
        for(int num : nums){
            if(num == majority1){
                count1++;
            }else if(num == majority2){
                count2++;
            }else if(count1 == 0){
                majority1 = num;
                count1 = 1;
            }else if(count2 == 0){
                majority2 = num;
                count2 = 1;
            }else{
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int num : nums){
            if(num == majority1) count1++;
            else if (num == majority2) count2++;
        }
        ArrayList<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3;
        if(count1 > threshold) result.add(majority1);
        if(count2 > threshold) result.add(majority2);
        Collections.sort(result);
        return result;
    }
}