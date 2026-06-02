class Solution {
    public int maxProfit(int[] arr) {
        int n=arr.length;

        int maxPro=0;

        int lowValue=arr[0];

        for(int i=0;i<n;i++){
            int val=arr[i]-lowValue;

            maxPro=Math.max(val,maxPro);

            lowValue=Math.min(lowValue,arr[i]);
        }

        return maxPro;
    }
    
}