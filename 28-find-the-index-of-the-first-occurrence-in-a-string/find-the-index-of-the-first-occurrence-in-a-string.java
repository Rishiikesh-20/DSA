class Solution {
    public int strStr(String s, String p) {
        int n=s.length();
        int m=p.length();
        int[] lps=new int[m+1];
        
        int i=1;
        int len=0;
        while(i<m){
            if(p.charAt(i)==p.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len!=0){
                    len=lps[len-1];
                }else{
                    lps[i]=0;
                    i++;
                }
            }
        } 

        i=0;
        int j=0;

        while(i<n){
            if(s.charAt(i)==p.charAt(j)){
                j++;
                i++;
            }else{
                if(j==0){
                    i++;
                }else{
                    j=lps[j-1];
                }
            }
            if(j==m){
                return i-m;
            }
        }
        return -1;
    }
}