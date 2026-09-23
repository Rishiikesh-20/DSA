class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] prefix=new int[n];
        prefix[0]=1;
        int prod=nums[0];
        for(int i=1;i<n;i++){
            prefix[i]=prod;
            prod*=nums[i];
        }

        int[] suffix=new int[n];
        suffix[n-1]=1;
        prod=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffix[i]=prod;
            prod*=nums[i];
        }


        int[] result=new int[n];

        for(int i=0;i<n;i++){
            result[i]=prefix[i]*suffix[i];
        }

        return result;

    }
}