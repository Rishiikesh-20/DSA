class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        int count=0;
        int len=arr.length;
        int i=0;
        if(n==0){
            return true;
        }
        while(i<len){
            if(arr[i]==1){
                i+=2;
            }else{
                if(i-1>=0 && arr[i-1]==1){
                    i++;
                    continue;
                }
                if(i+1<len && arr[i+1]==1){
                    i+=3;
                    continue;
                }

                count++;
                if(count==n){
                    return true;
                }
                i+=2;

            }
        }
        return false;
    }
}