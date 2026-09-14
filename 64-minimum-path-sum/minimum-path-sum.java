class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] prev=new int[n];
        int[] cur=new int[n];
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=grid[0][i];
            prev[i]=sum;
        }

        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                int top=Integer.MAX_VALUE;
                int left=Integer.MAX_VALUE;
                if(j-1>=0){
                    left=cur[j-1];
                }
                top=prev[j];
                cur[j]=Math.min(top,left);
                cur[j]+=grid[i][j];
            }
            prev=cur;
        }
        return prev[n-1];
    }
}