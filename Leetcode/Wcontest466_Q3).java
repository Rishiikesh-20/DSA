package Leetcode;

class Solution {
    
    public long bowlSubarrays(int[] arr) {
        int sum=0;
        int n=arr.length;
        for(int i=0;i<n;i++){
            int count=0;
            int maxEle=Integer.MIN_VALUE;
            for(int j=i+1;j<n;j++){
                int isGreater=arr[j]>arr[i]?1:0;
                if(isGreater==1 && count==0){
                    break;
                }
                if(isGreater==0){
                    count++;
                    if(count>=2){
                        if(maxEle<arr[j]){
                            sum++;
                        }
                    }
                }else{
                    sum++;
                    break;
                }
                maxEle=Math.max(maxEle,arr[j]);
            }
        }
        return sum;
    }
}
