class NumMatrix {
    int[][] dp;
    public NumMatrix(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        dp=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int top=0;
                int left=0;
                int temp=0;
                if(i-1>=0){
                    top=dp[i-1][j];
                }
                if(j-1>=0){
                    left=dp[i][j-1];
                }
                if(i-1>=0 && j-1>=0){
                    temp=dp[i-1][j-1];
                }
                dp[i][j]=matrix[i][j]+top+left-temp;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int top=0;
        int bottom=0;
        int temp=0;
        if(row1-1>=0)
            top=dp[row1-1][col2];
        if(col1-1>=0)
            bottom=dp[row2][col1-1];
        if(row1-1>=0 && col1-1>=0){
            temp=dp[row1-1][col1-1];
        }
        System.out.println("dp: "+dp[row2][col2]+" Top: "+top+" Bottom: "+bottom+" Result: "+(dp[row2][col2]-top-bottom+dp[0][0]));
        return dp[row2][col2]-top-bottom+temp;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */