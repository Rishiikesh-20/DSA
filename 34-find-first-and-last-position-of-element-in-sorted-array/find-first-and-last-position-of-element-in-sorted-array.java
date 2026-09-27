class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first=-1;
        int second=-1;

        int n=nums.length;

        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]>=target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        if(low!=n && nums[low]==target)
            first=low;
        if(first==-1){
            return new int[]{-1,-1,};
        }

        low=0;
        high=n-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]<=target){
               low=mid+1;
            }else{
                high=mid-1;
            }
        }
        if(high!=-1 && nums[high]==target)
            second=high;

        return new int[]{first,second};
    }
}