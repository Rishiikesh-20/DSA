class Solution {
    public int maxProduct(int n) {
        int first=-1;
        int second=Integer.MIN_VALUE;

        int copy=n;
        while(copy>0){
            int rem=copy%10;
            if(rem>first){
                second=first;
                first=rem;
            }else if(second<rem){
                second=rem;
            }
            copy/=10;
        }

        return first*second;
    }
}