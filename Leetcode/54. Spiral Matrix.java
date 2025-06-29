package Leetcode;

import java.util.ArrayList;
import java.util.List;

// Time Complexity: O(m*n)
// space complexity : O(1) 

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Spiral Matrix.

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        List<Integer> result=new ArrayList<>();

        for(int i=0;i<=m/2 && m-2*i>0 && n-2*i>0;i++){
            
            for(int j=0;j<n-2*i;j++){
                result.add(matrix[i][j+i]);
            }
            
            for(int j=0;j<m-2*i-1;j++){
                result.add(matrix[j+i+1][n-i-1]);
            }
            
            if(m-i-1 > i){
                for(int j=0;j<n-2*i-1;j++){
                    result.add(matrix[m-i-1][n-j-i-2]);
                }
            }
            
            if(i<n-i-1){
                for(int j=0;j<m-2*i-2;j++){
                    result.add(matrix[m-j-i-2][i]);
                }
            }
            
        }

        return result;
    }
}


