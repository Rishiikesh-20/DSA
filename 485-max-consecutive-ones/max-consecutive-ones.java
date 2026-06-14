class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int n=arr.length;
        int cur=0;
        int max=0;

        for(int i=0;i<n;i++){
            if(arr[i]==1){
                cur++;
            }else{
                cur=0;
            }
            max=Math.max(cur,max);
        }
        return max;
    }
}