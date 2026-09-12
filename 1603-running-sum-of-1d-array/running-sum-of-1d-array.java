class Solution {
    public int[] runningSum(int[] arr) {
        int sum=0;
        int n=arr.length;
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            sum+=arr[i];
            result[i]=sum;
        }
        return result;
    }
}