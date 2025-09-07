package Leetcode;

class Solution {
    public int minOperations(int[] nums) {
        int ele=nums[0];
        for(int i=1;i<nums.length;i++){
            if(ele!=nums[i]){
                return 1;
            }
        }
        return 0;
    }
}
