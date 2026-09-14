class Solution {
    public boolean canPartition(int[] nums) {
        int sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2==1) return false;

        int target=sum/2;

        boolean[][] dp=new boolean[n][sum+1];

        /*
            dp[i][j]=using coins till i , can i able to form j 

            dp[i][j]=dp[i-1][j-nums[i]] || dp[i-1][j]
        */

        dp[0][nums[0]]=true;
        for(int i=1;i<n;i++){
            for(int j=0;j<=sum;j++){
                if(j-nums[i]>=0)
                    dp[i][j]=dp[i-1][j-nums[i]];
                dp[i][j]=dp[i][j] || dp[i-1][j];
            }
        }
        return dp[n-1][target];
    }
}