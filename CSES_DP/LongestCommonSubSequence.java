import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class LongestCommonSubSequence {
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
            dp[i][j]=no of longest subsequence possible

            dp[i][j]=if same => dp[i-1][j-1] + 1
            no means
            dp[i][j]=dp[i-1][j]+dp[i][j-1]

            basecase = dp[i][0]=0 dp[0][j]=0 dp[0][0]=0 
        */
        int n=in.nextInt();
        int m=in.nextInt();

        int[] a=new int[n];
        int[] b=new int[m];

        for(int i=0;i<n;i++){
            a[i]=in.nextInt();
        }
        for(int i=0;i<m;i++){
            b[i]=in.nextInt();
        }

        int[][] dp=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(a[i-1]==b[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        System.out.println(dp[n][m]);

        int i=n;
        int j=m;
        Stack<Integer> stack=new Stack<>();
        while (i > 0 && j > 0) {
            if (a[i-1] == b[j-1]) {
                stack.push(a[i-1]); // use a[i-1], not a[i]
                i--;
                j--;
            } else if (dp[i-1][j] > dp[i][j-1]) {
                i--;
            } else {
                j--;
            }
        }

        int s=stack.size();
        for(i=0;i<s;i++){
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
        
        out.close();
    }
}
