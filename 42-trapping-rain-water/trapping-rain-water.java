class Solution {
    public int trap(int[] arr) {
        int n=arr.length;
        int left=0,right=n-1,leftMax=0,rightMax=0,total=0;

        while(left<right){
            if(arr[left]<=arr[right]){
                if(leftMax>arr[left]){
                    total+=(leftMax-arr[left]);
                }else{
                    leftMax=arr[left];
                }
                left++;
            }else{
                if(rightMax>arr[right]){
                    total+=(rightMax-arr[right]);
                }else{
                    rightMax=arr[right];
                }
                right--;
            }
        }
        return total;
    }
}