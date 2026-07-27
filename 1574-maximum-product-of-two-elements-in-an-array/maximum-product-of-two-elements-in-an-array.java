class Solution {
    public int maxProduct(int[] arr) {
        int n=arr.length;
        int max1=0;
        int max2=-1;

        for(int i=0;i<n;i++){
            if(max1<arr[i]){
                max2=max1;
                max1=arr[i];
            }else if(max2<arr[i]){
                max2=arr[i];
            }
        }
        return (max1-1)*(max2-1);
    }
}