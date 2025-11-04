import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ArrayDescription {
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

        int n=in.nextInt();
        int m=in.nextInt();

        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        /*

         */
        long[][] dp=new long[n+1][m+1];

        for(int i=1;i<=m;i++){
            if(arr[0]==i || arr[0]==0){
                dp[1][i]=1;
            }
        }

        for(int i=2;i<=n;i++){
            for(int k=1;k<=m;k++){
                if(arr[i-1]!=0 && arr[i-1]!=k){
                    dp[i][k]=0;
                    continue;
                }

                for(int j=k-1;j<=k+1;j++){
                    if(j>=1 && j<=m){
                        dp[i][k]=(dp[i][k]+dp[i-1][j])%MOD;
                    }
                }
            }
        }
        long result=0;
        for(int i=1;i<=m;i++){
            result=(result+dp[n][i])%MOD;
        }
        System.out.println(result);
        out.close();
    }
}
