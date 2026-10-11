class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                swap(matrix,i,j,j,i);
            }
        }

        for(int i=0;i<n;i++){
            reverse(matrix,i,0,n-1);
        }

    }

    public void swap(int[][] arr,int i1,int j1,int i2,int j2){
        int temp=arr[i1][j1];
        arr[i1][j1]=arr[i2][j2];
        arr[i2][j2]=temp;
    }
    public void reverse(int[][] arr,int row,int j1,int j2){
        while(j1<j2){
            swap(arr,row,j1,row,j2);
            j1++;
            j2--;
        }
    }
}