class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        int total=0;

        if(n<=2){
            return n;
        }

        int powerTwo=0;

        int copy=n;
        while(copy>0){
            copy=(copy>>1);
            powerTwo++;
        }

        int num=(1<<powerTwo)-1;

        return num+1;

    }
}