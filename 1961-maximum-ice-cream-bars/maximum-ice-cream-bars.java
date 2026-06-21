class Solution {
    public int maxIceCream(int[] arr, int coins) {
        int n=arr.length;
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,arr[i]);
        }

        int[] temp=new int[max+1];

        for(int i=0;i<n;i++){
            temp[arr[i]]++;
        }
        int k=0;
        for(int i=0;i<temp.length && k<n;i++){
            if(temp[i]>0){
                while(temp[i]!=0){
                    arr[k++]=i;
                    temp[i]--;
                }
            }
        }
        int result=0;
        for(int i=0;i<arr.length;i++){
            if(coins-arr[i]>=0){
                result++;
                coins-=arr[i];
            }else{
                break;
            }  
        }  

        return result; 
    }
}