import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CountingTowers {
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
            dp[i][0] = no of possible grid can be formed from  i to n-1 
                        if a horizontal block is coming from i-1
            
            dp[i][1] = no of possible grid can be formed from  i to n-1 
                        if a two vertical block is coming from i-1

            dp[i][0] = 2*dp[i+1][0] + dp[i+1][1]
            dp[i][1] = dp[i+1][0] + 4*dp[i+1][1]

            base case
                dp[n-1][0]=1 dp[n-1][1]=1

            i=n-2 to i=1

            i=0 => dp[0][1]=0 , dp[0][0]=2*dp[i+1][0] + dp[i+1][1]
         */
        

        int t=in.nextInt();
        while(t-->0){
            int n=in.nextInt();
            long[] nextState=new long[2];

            // basecase
            nextState[0]=1;
            nextState[1]=1;

            for(int i=n-1;i>=1;i--){
                long[] currentState=new long[2];
                currentState[0]=(2*nextState[0]+nextState[1])%MOD;
                currentState[1]=(nextState[0]+4*nextState[1])%MOD;
                nextState=currentState;
            }

            System.out.println((nextState[0]+nextState[1])%MOD);   
        }
        out.close();
    }
}
