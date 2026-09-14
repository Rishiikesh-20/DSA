class Solution {
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];

        /* dp[i][j]=min no of operation to make word1 of length i to length j of word2 */
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
        }
        for(int i=0;i<=n;i++){
            dp[0][i]=i;
        }
        if(m==0 && n==0) return 0;

        for(int i=1;i<=m;i++){
            dp[i][0]=i;
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    int replace=Integer.MAX_VALUE;
                    int insert=Integer.MAX_VALUE;
                    int delete=Integer.MAX_VALUE;
                    if(dp[i-1][j-1]!=Integer.MAX_VALUE)
                        replace=1+dp[i-1][j-1];
                    if(dp[i][j-1]!=Integer.MAX_VALUE)
                        insert=1+dp[i][j-1];
                    if(dp[i-1][j]!=Integer.MAX_VALUE)
                        delete=1+dp[i-1][j];
                    dp[i][j]=Math.min(delete,Math.min(replace,insert));
                }
            }
        }
        return dp[m][n];
    }

}