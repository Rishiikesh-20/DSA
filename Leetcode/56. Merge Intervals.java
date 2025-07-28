

// Beats 85.63% | 8ms

package Leetcode;
import java.util.*;
class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;

        Arrays.sort(intervals,new Comparator<int[]>(){
            @Override
            public int compare(int[] row1,int[] row2){
                return Integer.compare(row1[0],row2[0]);
            }
        });

        ArrayList<Integer[]> result=new ArrayList<>();

        int[] temp=new int[2];
        temp[0]=intervals[0][0];
        temp[1]=intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]<=temp[1]){
                if(intervals[i][1]>temp[1]){
                     temp[1]=intervals[i][1];
                }
            }else{
                result.add(new Integer[]{temp[0],temp[1]});
                temp[0]=intervals[i][0];
                temp[1]=intervals[i][1];
            }
        } 
        result.add(new Integer[]{temp[0],temp[1]});


        int[][] arrResult=new int[result.size()][2];

        for(int i=0;i<arrResult.length;i++){
            arrResult[i][0]=result.get(i)[0];
            arrResult[i][1]=result.get(i)[1];
        } 

        return arrResult;
    }
}