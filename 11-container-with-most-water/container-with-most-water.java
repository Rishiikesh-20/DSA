class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int low=0;
        int high=n-1;
        int max=0;
        while(low<high){
            int left=height[low];
            int right=height[high];
            int hei=Math.min(left,right);
            int width=high-low;
            max=Math.max(hei*width,max);
            if(left<=right){
                low++;
            }else{
                high--;
            }
        }
        return max;
    }
}