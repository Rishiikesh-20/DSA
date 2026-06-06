class Solution {
    public double myPow(double x, int n) {
        if(n>0){
            if(n%2==0){
                double val=myPow(x,n/2);
                return val*val;
            }else{
                double val=myPow(x,(n-1)/2);
                return x*val*val;
            }
        }else if(n<0){
            if(n%2==0){
                double val=myPow(x,n/2);
                return val*val;
            }else{
                double val=myPow(x,(n+1)/2);
                return (1/x)*val*val;
            }
        }else{
            return 1;
        }
    }
}