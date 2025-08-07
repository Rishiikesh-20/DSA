package CodeForces;

import java.util.Scanner;

public class contest_2126A{
    // Input        // output 
    // 5             // 6
    // 6             // 6
    // 96            // 7
    // 78            // 1
    // 122           // 6         
    // 696
    
    public static int onlyDigit(int n){
        int min=Integer.MAX_VALUE;
        while(n>0){
            int rem=n%10;
            if(min>rem){
                min=rem;
            }
            n=n/10;
        }
        return min;
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            result[i]=onlyDigit(in.nextInt());
        }
        for(int i=0;i<n;i++){
            System.out.println(result[i]);
        }
    }
}   
