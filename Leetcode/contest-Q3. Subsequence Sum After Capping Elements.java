// Need to upsolve
class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n=nums.length;
        boolean[] result=new boolean[n];
        for(int x=1;x<=n;x++){
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=Math.min(nums[i],x);
            }
            result[x-1]=recur(arr,arr.length,0,0,k); 
        }
        return result;
    }
    public boolean recur(int[] arr,int n,int i,int sum,int k){
        if(sum==k) return true; 
        if(n==i){
            return false;
        }
        sum+=arr[i];   
        
        return recur(arr,n,i+1,sum,k) || recur(arr,n,i+1,sum-=arr[i],k);
    } 
}©leetcode