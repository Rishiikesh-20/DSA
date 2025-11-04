import java.util.Arrays;
import java.util.Scanner;

public class diceCombinations{
    public static long computeWaysIterative(int n){
        /* 
            subproblem
            dp[n] is the no of ways to get sum of n. 
            n can be obtained by taking sum of dp[k-1],dp[k-2],dp[k-3],dp[k-4],dp[k-5],dp[k-6]  
            base case - dp[0] =1 because 0 can be obtained by not doing anything and it is counted as 1 way
        */
        long[] dp=new long[n+1];
        dp[0]=1;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=6;j++){
                if(i-j<0) break;
                dp[i]=(dp[i]+dp[i-j])%(1000000007);
            }
        }
        return dp[n];
    }
    public static long computeWaysRecursive(long[] dp,int n){
        if(n<0) return 0;
        if(n==0) {
            dp[0]=1;
            return dp[0];
        };
        if(dp[n]!=-1) return dp[n];
        dp[n]=0;
        for(int i=1;i<=6;i++){
            dp[n]=(dp[n]+computeWaysRecursive(dp, n-i))%(1000000007);
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        long[] dp=new long[n+1];
        Arrays.fill(dp,-1);
        System.out.println(computeWaysRecursive(dp,n));
    }
}