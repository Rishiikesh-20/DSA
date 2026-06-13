class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<n-2;i++){
            if(i-1>=0 && arr[i]==arr[i-1]) continue;
           int low=i+1;
           int high=n-1;

            while(low<high){
                int sum=arr[i]+arr[low]+arr[high];
                if(sum==0){
                    result.add(new ArrayList<>(List.of(arr[i],arr[low],arr[high])));

                    while(low<high && arr[low]==arr[low+1]){
                        low++;
                    }
                    while(low<high && arr[high]==arr[high-1]){
                        high--;
                    }
                    low++;
                    high--;
                }else if(sum>0){
                    high--;
                }else{
                    low++;
                }
            }
        }
        return result;
    }
}