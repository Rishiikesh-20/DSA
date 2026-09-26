class Solution {
    public int consecutiveNumbersSum(int n) {
        /*
            x+x+1+x+2+x+3+...+x+k-1=k.x + k.(k-1)/2
            n=k.x+k.(k-1)/2

            n-k(k-1)/2=x.k
        
         */
        int count=0;
        for(int k=1;n>0;n-=k,k++){
            if(n%k==0){
                count++;
            }
        }
        return count;
    }
}