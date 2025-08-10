package CodeForces;

import java.util.Scanner;

public class contest_2127A {
    public static boolean mex(int[] arr){
        // 3
        int n=arr.length;
        for(int i=0;i<=n-2;i++){
            int a=arr[i];
            int b=arr[i+1];
            int c=arr[i+2];

            // 0,1,2,3 = mex
            int mex;
            if(a!=0 && b!=0 && c!=0){
                mex=0;
            }else if(a!=1 && b!=1 && c!=1){
                mex=1;
            }else if(a!=2 && b!=2 && c!=2){
                mex=2;
            }else{
                mex=3;
            }

            // Replace the -1 
            // Edge case 0 1 -1 mex=max-min you know mex . if max is not -1 , you can find min (but max>mex otherwise )
        }
        return true;
    }
    public static void main(){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();

        for(int i=0;i<n;i++){
            int m=in.nextInt();
            int[] arr=new int[m];
            for(int j=0;j<m;j++){
                arr[i]=in.nextInt();
            }
            if(mex(arr)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
