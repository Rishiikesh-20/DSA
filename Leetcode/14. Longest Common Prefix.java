package Leetcode;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 100% Beats | 0ms
        String prefix=strs[0];

        for(int i=1;i<strs.length;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;

        // 67 % | 1ms

        // int n=strs.length;

        // int c=strs[0].length();
        // for(int i=1;i<n;i++){
        //     c=Math.min(c,strs[i].length());
        // }
        // boolean flag=false;
        // StringBuilder s1=new StringBuilder();
        // for(int i=0;i<c;i++){
        //     for(int j=1;j<n;j++){
        //         if(strs[0].charAt(i)==strs[j].charAt(i)){
                    
        //         }else{
        //             flag=true;
        //             break;
        //         }
        //     }
        //     if(flag){
        //         break;
        //     }else{
        //         s1.append(strs[0].charAt(i)+"");
        //     }
        // }
        // return s1.toString();
    }
}