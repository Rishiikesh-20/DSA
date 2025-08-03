package Leetcode;
import java.util.*;
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder s1=new StringBuilder();
        int c=-1;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                if(c==-1){
                    c++;
                    continue;
                }
                c++;
                s1.append("(");
            }else{
                c--;
                if(c==-1){
                    continue;
                }
                s1.append(")");
                
            }
            
        }
        return s1.toString();
    }
}