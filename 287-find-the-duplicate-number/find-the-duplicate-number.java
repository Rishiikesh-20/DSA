class Solution {
    public int findDuplicate(int[] nums) {
        int n=nums.length;
       
        int i=nums[nums[0]];
        int j=nums[0];

        while(i!=j){
            i=nums[nums[i]];
            j=nums[j];
        }
        i=0;
        while(i!=j){
            i=nums[i];
            j=nums[j];
        }
        return i;
    }
}