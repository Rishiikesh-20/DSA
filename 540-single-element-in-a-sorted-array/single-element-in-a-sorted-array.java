class Solution {
    public int singleNonDuplicate(int[] arr) {
        int n=arr.length;
        int low=0;
        int high=n-1;

        while(low<high){
            int mid=low+(high-low)/2;

            if(arr[mid]==arr[mid+1]){
                if((n/2)%2==0){
                    low=mid+2;
                }else{
                    high=mid-1;
                }
            }else if(arr[mid]==arr[mid-1]){
                if((n/2)%2==0){
                    high=mid-2;
                }else{
                    low=mid+1;
                }
            }else{
                return arr[mid];
            }
            n=high-low+1;
            System.out.println("low: "+low+" high: "+high);
        }
        return arr[low];
    }
}