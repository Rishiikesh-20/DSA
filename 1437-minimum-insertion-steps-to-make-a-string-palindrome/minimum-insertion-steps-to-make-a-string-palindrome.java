class Solution {
    public int minInsertions(String s) {
        char[] arr1=s.toCharArray();
        int n=arr1.length;

        int[][] dp=new int[n+1][n+1];

        String p=new StringBuilder(s).reverse().toString();
        char[] arr2=p.toCharArray();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        int x=dp[n][n];

        return n-x;
    }
    
}