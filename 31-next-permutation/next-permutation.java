class Solution {
    public void nextPermutation(int[] arr) {
        int n=arr.length;

        int i=n-2;

        while(i>=0 && arr[i]>=arr[i+1]){
            i--;
        }

        int j=n-1;
        while(i!=-1 && j>i){
            if(arr[j]>arr[i]){
                int temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                break;
            }
            j--;
        }

        int l=i+1;
        int r=n-1;

        while(l<r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;

            l++;
            r--;
        }

    }
}