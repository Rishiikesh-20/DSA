package Leetcode;

class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n=strategy.length;
        long maxSum=0;
        for(int j=0;j<strategy.length;j++){
            maxSum+=strategy[j]*prices[j];
        }
        long baseProfit=maxSum;
        int[] zero=new int[n];
        int[] one=new int[n];
        for(int i=0;i<n;i++){
            zero[i]=-1*strategy[i]*prices[i];
        }
        for(int j=i+(k/2);j<i+k;j++){
            one[i]=(1-strategy[j])*prices[j];
        }
        
        for(int i=0;i<n-1 && i+k-1<strategy.length;i++){
            int temp=0;
            
            long sum=temp+baseProfit;
            maxSum=Math.max(sum,maxSum);
        }     
        return maxSum;
    }
}©leetcode