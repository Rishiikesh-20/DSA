package Leetcode;
import java.util.*;
class Solution {
    public List<String> generateBinaryStrings(int n) {
        List<String> list=new ArrayList<>();
        binary(n,"",0,0,list);
        return list;
    }
    public void binary(int n,String s,int i,int prev,List<String> result){
        if(i==n){
            result.add(s);
            return;
        }
        String s1=s+"0";
        binary(n,s1,i+1,0,result);
        if(prev==0){
            s1=s+"1";
            binary(n,s1,i+1,1,result);
        }
    }
}
