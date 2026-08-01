class Solution {
    public boolean predictTheWinner(int[] arr) {
        int n=arr.length;
        if(recur(0,n-1,arr)>=0){
            return true;
        }
        return false;
    }

    public int recur(int i,int j,int[] arr){
        if(i==j){
            return arr[i];
        }
        return Math.max(arr[i]-recur(i+1,j,arr),arr[j]-recur(i,j-1,arr));
    }
}