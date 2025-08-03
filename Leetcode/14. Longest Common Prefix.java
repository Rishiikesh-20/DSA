package Leetcode;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;

        int c=strs[0].length();
        for(int i=1;i<n;i++){
            c=Math.min(c,strs[i].length());
        }
        boolean flag=false;
        StringBuilder s1=new StringBuilder();
        for(int i=0;i<c;i++){
            for(int j=1;j<n;j++){
                if(strs[0].charAt(i)==strs[j].charAt(i)){
                    
                }else{
                    flag=true;
                    break;
                }
            }
            if(flag){
                break;
            }else{
                s1.append(strs[0].charAt(i)+"");
            }
        }
        return s1.toString();
    }
}