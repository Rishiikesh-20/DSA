package Leetcode;
import java.util.*;
class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        subsetRecur(nums,-1,0,new ArrayList<>(),result);
        return result;
    }
    public void subsetRecur(int[] nums,int skipped,int i,List<Integer> temp,List<List<Integer>> result){
        if(i==nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(skipped==-1 || nums[i]!=nums[i-1]){
            temp.add(nums[i]);
            subsetRecur(nums,-1,i+1,temp,result);
            temp.remove(Integer.valueOf(nums[i]));
        }
        subsetRecur(nums,nums[i],i+1,temp,result);
    }
}
