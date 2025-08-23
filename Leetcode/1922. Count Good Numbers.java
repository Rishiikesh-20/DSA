package Leetcode;

class Solution {
    public int countGoodNumbers(long n) {
       long fivePow=(n+1)/2;
       long fourPow=(n)/2;

       return (int)((findfunc(5,fivePow)*findfunc(4,fourPow))%((long)1000000007));
    }
    public static long findfunc(int num,long n){
        if(n==0){
            return 1;
        }
        long result;
        if(n%2==0){
            result=findfunc(num,n/2);
            return result*result%((long)1000000007);
        }else{
            result=findfunc(num,n/2);
            return result*result*num%((long)1000000007);
        }
    }
}
