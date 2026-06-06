class Solution {
    public int majorityElement(int[] nums) {
        int cur=nums[0];
        int count=1;
        int n=nums.length;

        if(n==1){
            return nums[0];
        }

        for(int i=1;i<n;i++){
            if(nums[i]==cur){
                count++;
            }else{
                count--;
            }
            if(count==-1){
                cur=nums[i];
                count=1;
            }
        }
        return cur;
    }
}