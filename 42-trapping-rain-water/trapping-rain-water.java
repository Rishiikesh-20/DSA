class Solution {
    public int trap(int[] arr) {
        int n=arr.length;

        int left=0;
        int right=n-1;

        int leftMax=arr[0];
        int rightMax=arr[n-1];

        int total=0;
        while(left<=right){
            if(arr[left]<arr[right]){
                if(arr[left]>=leftMax){
                    leftMax=arr[left];
                }else{
                    total+=(leftMax-arr[left]);
                }
                left++;
            }else{
                if(arr[right]>=rightMax){
                    rightMax=arr[right];
                }else{
                    total+=(rightMax-arr[right]);
                }
                right--;
            }
        }
        return total;
    }
}