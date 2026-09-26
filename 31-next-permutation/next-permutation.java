class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length==1) return;
        int n=nums.length;
        // ArrayList<Integer> list=new ArrayList<>();
        int ind=n-2;
        for(ind=n-2;ind>=0;ind--){
            if(nums[ind]<nums[ind+1]){
                break;
            }
        }

        if(ind==-1){
            reverse(nums,0,n-1);
            return;
        }

        for(int i=n-1;i>ind;i--){
            if(nums[ind]<nums[i]){
                swap(nums,ind,i);
                break;
            }
        }
        reverse(nums,ind+1,n-1);
    }
    public void reverse(int[] arr,int start,int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }
    public void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}