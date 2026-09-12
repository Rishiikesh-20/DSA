class Solution {
    public int countKeyChanges(String s) {
        int count=0;
        char[] arr=s.toCharArray();
        int n=arr.length;
        if(n==1) return 0;
        for(int i=0;i<n-1;i++){
            if((int)arr[i]!=(int)arr[i+1]+32 && (int)arr[i]!=(int)arr[i+1]-32 && arr[i]!=arr[i+1]){
                count++;
            }
        }
        return count;
    }
}