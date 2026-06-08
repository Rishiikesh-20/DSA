class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<n-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<n-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int l=j+1;
                int r=n-1;

                while(l<r){
                    long val=(long)nums[i]+(long)nums[j]+nums[l]+nums[r];
                    if(val==target){
                        result.add(new ArrayList<>(List.of(nums[i],nums[j],nums[l],nums[r])));
                        l++;
                        r--;

                        while(l<r && nums[l]==nums[l-1]) l++;
                        while(l<r && nums[r]==nums[r+1]) r--;
                    }else if(val>target){
                        r--;
                    }else{
                        l++;
                    }
                } 
            }
        }
        return result;
    }
}