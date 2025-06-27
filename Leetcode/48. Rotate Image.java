package Leetcode;
//Paste below code in leetcode
class Solution {
    public void rotate(int[][] arr) {
        int n=arr.length;

       for(int i=0;i<n/2;i++){
        for(int j=0;j<n-2*i-1;j++){
            int a=arr[i][i+j];
            int b=arr[i+j][n-i-1];
            int c=arr[n-i-1][n-i-1-j];
            int d=arr[n-i-1-j][i];

            arr[i+j][n-i-1]=a;
            arr[n-i-1][n-i-1-j]=b;
            arr[n-i-1-j][i]=c;
            arr[i][i+j]=d;
        }
       }
    }
}