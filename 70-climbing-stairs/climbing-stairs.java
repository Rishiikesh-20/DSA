class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=1;
        
        for(int i=1;i<=n;i++){
            int way1=dp[i-1];
            int way2=0;
            if(i-2>=0){
                way2=dp[i-2];
            }
            dp[i]=way1+way2;
        }
        return dp[n];

    }
}
