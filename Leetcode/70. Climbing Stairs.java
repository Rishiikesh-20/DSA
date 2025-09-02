package Leetcode;
import java.util.*;

class Solution {
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        for(int i=2;i<=n;i++){
            dp[i]=-1;
        }
        return dpRecur(n,dp);
    }

    public int dpRecur(int n,int[] dp){
        if(n==0){
            return 1;
        }
        if(n==1){
            return 1;
        }
        if(dp[n]!=-1) return dp[n];
        int OneWay=dpRecur(n-1,dp);
        int TwoWay=dpRecur(n-2,dp);

        return dp[n]=OneWay+TwoWay;
    }
}
