class Solution {
    public int candy(int[] arr) {
        int n=arr.length;
        if(n==1){
            return 1;
        }
        int[] left=new int[n];
        int[] right=new int[n];

        Arrays.fill(left,1);
        Arrays.fill(right,1);

        for(int i=1;i<n;i++){
            if(arr[i]>arr[i-1]){
                left[i]=left[i-1]+1;
            }
        }
        if(arr[0]>arr[1]){
            left[0]=left[1]+1;
        }

        for(int i=n-2;i>=0;i--){
            if(arr[i]>arr[i+1]){
                right[i]=right[i+1]+1;
            }
        }
        if(arr[n-1]>arr[n-2]){
            right[n-1]=right[n-2]+1;
        }

        int result=0;

        for(int i=0;i<n;i++){
            result+=Math.max(left[i],right[i]);
        }
        return result;
    }
}