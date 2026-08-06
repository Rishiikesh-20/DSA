class Solution {
    public int smallestNumber(int n, int t) {
        int prod=1;
        int copy=n;

        while(copy>0){
            int rem=copy%10;
            prod*=rem;
            copy/=10;
        }
        int rem=prod%t;

        if(rem==0) return n;

        while(true){
            n+=1;
            prod=1;
            copy=n;
            while(copy>0){
                rem=copy%10;
                prod*=rem;
                copy/=10;
            }
            rem=prod%t;
            if(rem==0) return n;
        }

    }
}