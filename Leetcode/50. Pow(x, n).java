package Leetcode;

class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }
        double result;
        if(n%2==0){
            int half=n/2;
            result=myPow(x,half);
            result=result*result;
        }else{
            int half=n/2;
            result=myPow(x,half);
            if(n<0){
                result=((double)1/x)*result*result;
            }else{
                result=((double)x)*result*result;
            }
        }
        return result;
    }
}
