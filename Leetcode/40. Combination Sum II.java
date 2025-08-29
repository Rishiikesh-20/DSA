package Leetcode;
import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(candidates);
        combinationRecur(candidates,target,0,0,new ArrayList<>(),result,-1);
        return result;
    }
    public void combinationRecur(int[] arr,int target,int i,int sum,List<Integer> temp,List<List<Integer>> result ,int skipped){
        if(sum>target){
            return;
        }
        if(i==arr.length){
            if(sum==target){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        
        if(skipped!=arr[i]){
            temp.add(arr[i]);
            combinationRecur(arr,target,i+1,sum+arr[i],temp,result,-1);
            temp.remove(Integer.valueOf(arr[i]));
        }
        combinationRecur(arr,target,i+1,sum,temp,result,arr[i]);
    }
}

