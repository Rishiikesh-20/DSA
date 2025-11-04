import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class EditDistance {
    static final Long MOD=(long)(1e9+7);
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {}
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                return null;
            }
        }
    }
    
    public static void main(String[] args) {
        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner();

        /*
            dp[i][j] = minimum cost to make A of length i and B of length j
                       to make them same 
            
            if(a[i-1]==b[i-1])
                dp[i][j]=dp[i-1][j-1]
            else
                replace 1st string last letter as 2nd string last letter
                dp[i][j]=dp[i-1][j-1]+1
                replace 2nd string last letter as 1st string last letter
                dp[i][j]=dp[i-1][j-1]+1
                add letter to string 1 or 2
                dp[i][j]=dp[i-1][j]+1
                dp[i][j]=dp[i][j-1]+1

            basecase 
            dp[0][0]=0 dp[i][0]=i dp[0][j]=j

         */

        String s1=in.nextLine();
        String s2=in.nextLine();
        int n=s1.length();
        int m=s2.length();
        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            dp[i][0]=i;
        }
        for(int i=1;i<=m;i++){
            dp[0][i]=i;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                    continue;
                }
                int min=Integer.MAX_VALUE;
                min=Math.min(dp[i-1][j-1]+1, min);
                min=Math.min(dp[i-1][j]+1, min);
                min=Math.min(dp[i][j-1]+1, min);

                dp[i][j]=min;
            }
        }
        System.out.println(dp[n][m]);
        
        out.close();
    }
}
