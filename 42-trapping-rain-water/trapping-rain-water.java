class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int low=0;
        int high=n-1;
        int result=0;

        int leftMax=height[0];
        int rightMax=height[n-1];

        while(low<high){
            leftMax=Math.max(leftMax,height[low]);
            rightMax=Math.max(rightMax,height[high]);
            if(height[low]<=height[high]){
                result+=Math.min(leftMax,rightMax)-height[low];
                low++;
            }else{
                result+=(Math.min(leftMax,rightMax)-height[high]);
                high--;
            }
        }
        return result;
    }
}