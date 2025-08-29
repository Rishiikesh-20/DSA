package Leetcode;
import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        combinationRecur(candidates,target,0,0,new ArrayList<>(),result);
        return result;
    }
    public void combinationRecur(int[] arr,int target,int i,int sum,List<Integer> temp,List<List<Integer>> result)  {
        if(sum>target){
            return;
        }
        if(i==arr.length){
            if(sum==target){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        temp.add(arr[i]);
        combinationRecur(arr,target,i,sum+arr[i],temp,result);
        temp.remove(temp.size()-1);
        combinationRecur(arr,target,i+1,sum,temp,result);
        return;
    }
}