class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        /*
            dp[i][j]=no of matchs till i in text1 and j in text2

            if matches 1+dp[i-1][j-1]
            else max(dp[i-1][j],dp[i][j-1])
        */
        int m=text1.length();
        int n=text2.length();
        int[] prev=new int[n+1];
        int[] cur=new int[n+1];

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    cur[j]=1+prev[j-1];
                }else{
                    cur[j]=Math.max(prev[j],cur[j-1]);
                }
            }
            int[] temp = prev;
            prev = cur;
            cur = temp;
        }
        return prev[n];

    }
}