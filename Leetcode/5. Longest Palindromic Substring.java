package Leetcode;

class Solution {
    public String longestPalindrome(String s) {
        String maxString="";
        int n=s.length();
        for(int i=0;i<n;i++){
            // odd
            int j=1;
            while(true){
                int left=i-j;
                int right=i+j;
                if(left<0 || right>n-1){
                    break;
                }

                if(s.charAt(left)==s.charAt(right)){
                    if(s.substring(left,right+1).length()>maxString.length()){
                        maxString=s.substring(left,right+1);
                    }
                }else{
                    break;
                }
                j++;
            }
            j=1;
            while(true){
                int left=i-j+1;
                int right=i+j;

                if(left<0 || right>n-1){
                    break;
                }

                if(s.charAt(left)==s.charAt(right)){
                    if(s.substring(left,right+1).length()>maxString.length()){
                        maxString=s.substring(left,right+1);
                    }
                }else{
                    break;
                }
                j++;
            }
        }

        if(maxString.equals("")){
            return s.charAt(0)+"";
        }

        return maxString;
    }
}
