class Solution {
    public void sortColors(int[] arr) {
        /*
            0 to low-1 - 0
            low to mid - unsorted parts
            mid+1 to high-1 - 1
            high to n-1 - 2

            mid to low 
            mid=1
            mid--
            low to high 
            high--
            mid
        */

        int n=arr.length;

        int low=0;
        int mid=n-1;
        int high=n-1;

        while(low<=mid){
            if(arr[low]==0){
                low++;
            }else if(arr[low]==1){
                int temp=arr[low];
                arr[low]=arr[mid];
                arr[mid]=temp;
                mid--;
            }else{
                int midTemp=arr[mid];

                arr[low]=midTemp;
                arr[mid]=1;
                mid--;

                arr[high]=2;

                high--;
            }
        }
    }
}