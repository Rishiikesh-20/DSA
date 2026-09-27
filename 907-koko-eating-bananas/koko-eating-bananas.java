class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;

        for(int i=0;i<piles.length;i++){
            high=Math.max(piles[i],high);
        }

        while(low<high){
            int mid=low+(high-low)/2;
            int est=0;
            for(int i=0;i<piles.length;i++){
                est+=(int)Math.ceil((double)piles[i]/mid);
            }
            if(est>h){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return high;
    }
}