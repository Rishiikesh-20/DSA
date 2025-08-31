package Leetcode;
import java.util.*;
class Solution {
    public List<String> letterCombinations(String digits) {
        HashMap<Integer,String> map=new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        char[] arr1=digits.toCharArray();
        char[] arr=new char[arr1.length];
        List<String> result=new ArrayList<>();
        combinationRecur(arr1,0,map,arr,result);
        return result;
    }
    public void combinationRecur(char[] digits,int i,HashMap<Integer,String> map,char[] string,List<String> result){
        if(i==digits.length){
            if(string.length==0){
                return;
            }
            result.add(new String(string));
            return;
        }
        String s=map.get(Integer.parseInt(String.valueOf(digits[i])));
        for(int j=0;j<s.length();j++){
            string[i]=s.charAt(j);
            combinationRecur(digits,i+1,map,string,result); 
        }
    }
}