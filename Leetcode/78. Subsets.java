package Leetcode;
import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list=new ArrayList<>();
        subsetCalculation(nums,0,list,new ArrayList<>());
        return list;
    }
    public void subsetCalculation(int[] nums,int idx,List<List<Integer>> list,List<Integer> temp){
        if(idx==nums.length){
            list.add(temp);
            return;
        }
        List<Integer> temp1=new ArrayList<Integer>();
        temp1.addAll(temp);
        temp1.add(nums[idx]);
        subsetCalculation(nums,idx+1,list,temp1);
        subsetCalculation(nums,idx+1,list,temp);
    }
}