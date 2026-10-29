class Solution {
    public int coinChange(int[] coins, int amount) {
        /*
        
            dp[i][amount]=minimum no of coins

            dp[i][amount]=min(dp[i][amount-i],dp[i-1][amount])
        */

        int n=coins.length;
        int[] prev=new int[amount+1];
        Arrays.fill(prev,Integer.MAX_VALUE);
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0){
                prev[i]=i/coins[0];
            }
        }

        for(int i=1;i<n;i++){
            int[] cur=new int[amount+1];
            Arrays.fill(cur,Integer.MAX_VALUE);
            for(int j=0;j<=amount;j++){
                int temp=Integer.MAX_VALUE;
                if(j-coins[i]>=0 && cur[j-coins[i]]!=Integer.MAX_VALUE){
                    temp=cur[j-coins[i]]+1;
                }
                cur[j]=Math.min(temp,prev[j]);
            }
            prev=cur;
        }
        return prev[amount]!=Integer.MAX_VALUE?prev[amount]:-1;    }
}