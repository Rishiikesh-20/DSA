package Leetcode;

class Solution {
    public String reverseWords(String s) {
        StringBuilder result=new StringBuilder();
        int n=s.length();
        StringBuilder temp=new StringBuilder();
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)==' '){
                if(temp.length()>0){
                    result.append(temp.reverse()+" ");
                    temp.delete(0,temp.length());
                }else{
                    continue;
                }
                
            }else{
                temp.append(s.charAt(i)+"");
            }  
        }
        if(temp.length()>0){
            result.append(temp.reverse());
        }
        if(result.charAt(result.length()-1)==' '){
            result.delete(result.length()-1,result.length());
        }
        return result.toString();
    }
}
