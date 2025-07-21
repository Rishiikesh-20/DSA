package Leetcode;
import java.util.*;
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arr= new ArrayList<>();
        for(int i=0;i<numRows;i++){
            arr.add(new ArrayList<>());
            int ans=1;
             arr.get(i).add(ans);
            for(int j=1;j<=i;j++){
                ans=ans*(i-j+1)/(j);
                arr.get(i).add(ans);
            }
        }
        return arr;
    }
}