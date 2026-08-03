class Solution {
    public String stoneGameIII(int[] arr) {
        /*
            dp[i]=max diff
            dp[i]=Max(sum-dp[i+1],sum-arr[i+2],sum-arr[i+3]);
        */
        int n=arr.length;
        int[] dp=new int[n+1];
        int sum=0;
        for(int i=n-1;i>=0;i--){
            int max=arr[i]-dp[i+1];
            sum=arr[i];
            if(i+2<=n){
                sum+=arr[i+1];
                max=Math.max(max,sum-dp[i+2]);
                if(i+3<=n){
                    sum+=arr[i+2];
                    max=Math.max(max,sum-dp[i+3]);
                }
            }
            dp[i]=max;
        }

        if(dp[0]>0){
            return "Alice";
        }else if(dp[0]<0){
            return "Bob";
        }else{
            return "Tie";
        }   

    }
    
}