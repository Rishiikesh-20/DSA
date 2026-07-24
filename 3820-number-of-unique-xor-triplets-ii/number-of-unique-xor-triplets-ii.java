class Solution {
    public int uniqueXorTriplets(int[] arr) {
        int n=arr.length;
        int[] pairTwo=new int[2048];
        int[] pairThree=new int[2048];

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                pairTwo[arr[i]^arr[j]]=1;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<2048;j++){
                if(pairTwo[j]==1)
                    pairThree[arr[i]^j]=1;
            }
        }

        int count=0;

        for(int val:pairThree){
            if(val==1) count++;
        }
        return count;
    }
}