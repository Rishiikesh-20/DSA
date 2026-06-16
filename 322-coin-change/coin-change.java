class Solution {
    public int coinChange(int[] coins, int amount) {
        /*
            dp[i][sum]=dp[i-1][sum] || 1+dp[i][sum-amount]
            dp[i][sum]=no of coins it can hold for sum till ith index
            base case -> 
         */

        int[] prev=new int[amount+1];
        int n=coins.length;
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
                int take=Integer.MAX_VALUE;
                int notTake=Integer.MAX_VALUE;
                if(j-coins[i]>=0 && cur[j-coins[i]]!=Integer.MAX_VALUE)
                    take=1+cur[j-coins[i]];
                notTake=prev[j];

                cur[j]=Math.min(take,notTake);
            }
            prev=cur;
        }

        return prev[amount]==Integer.MAX_VALUE?-1:prev[amount];

    }
}