class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backTrack(nums,0,result);
        return result;
    }
    public void backTrack(int[] nums,int start,List<List<Integer>> result){
        if(start==nums.length){
            List<Integer> current=new ArrayList<>();
            for(int i:nums){
                current.add(i);
            }
            result.add(current);
            return;
        }

        for(int i=start;i<nums.length;i++){
            swap(nums,start,i);
            backTrack(nums,start+1,result);
            swap(nums,start,i);
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}