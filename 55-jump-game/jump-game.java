class Solution {
    public boolean canJump(int[] nums) {
        int n=nums.length;
        boolean[] temp=new boolean[n];
        temp[n-1]=true;
        for(int i=n-2;i>=0;i--){
            for(int j=1;j<=nums[i];j++){
                if(i+j>=n) break;

                if(temp[i+j]==true){
                    temp[i]=true;
                    break;
                }
            }
        }
        return temp[0];
    }
}