package Leetcode;

import java.util.Arrays;

class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        return dpSol(dp,n,costs);
    }
    public int dpSol(int[] dp,int n,int[] costs){
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1) return dp[n];

        int s1=dpSol(dp,n-1,costs)+costs[n-1]+1;
        int result=s1;
        int s2=Integer.MAX_VALUE;
        if(n>1){
            s2=dpSol(dp,n-2,costs)+costs[n-1]+4;
        }
        result=Math.min(result,s2);
        int s3=Integer.MAX_VALUE;
        if(n>2){
            s3=dpSol(dp,n-3,costs)+costs[n-1]+9;
        }
        result=Math.min(result,s3);
        dp[n]=result;
        return result;
    }
}
