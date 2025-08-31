package Leetcode;
import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result=new ArrayList<>();
        combinationRecur(k,n,0,1,0,new ArrayList<>(),result);
        return result;
    }
    public void combinationRecur(int k,int n,int sum,int i,int ind,List<Integer> temp,List<List<Integer>> result){
        if(ind==k){
            if(sum==n){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        if(i>9){
            return;
        }
        if(sum>n){
            return;
        }
        temp.add(i);
        combinationRecur(k,n,sum+i,i+1,ind+1,temp,result);
        temp.remove(Integer.valueOf(i));
        combinationRecur(k,n,sum,i+1,ind,temp,result);
    }
}
