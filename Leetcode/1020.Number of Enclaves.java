package Leetcode;
import java.util.*;
class Solution {
    public int numEnclaves(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int count=0;
        int[][] visited=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    count++;
                }  
            }
        }

        for(int i=0;i<4;i++){
            if(i==0){
                for(int j=0;j<n;j++){
                    if(grid[0][j]==1 && visited[0][j]!=1){
                        count=dfs(grid,visited,0,j,count);
                    }
                }
            }else if(i==1){
                for(int j=0;j<m;j++){
                    if(grid[j][n-1]==1 && visited[j][n-1]!=1){
                        count=dfs(grid,visited,j,n-1,count);
                    }
                }
            }else if(i==2){
                for(int j=0;j<n;j++){
                    if(grid[m-1][n-j-1]==1 && visited[m-1][n-j-1]!=1){
                        count=dfs(grid,visited,m-1,n-j-1,count);
                    }
                }
            }else{
                for(int j=0;j<m;j++){
                    if(grid[m-j-1][0]==1 && visited[m-j-1][0]!=1){
                        count=dfs(grid,visited,m-j-1,0,count);
                    }
                }
            }
        }

        return count;
    }

    public int dfs(int[][] grid,int[][] visited,int i,int j,int count){
        visited[i][j]=1;
        count--;
        int[] xarr={-1,0,1,0};
        int[] yarr={0,1,0,-1};
        for(int k=0;k<4;k++){
            int x=i+xarr[k];
            int y=j+yarr[k];

            if(x>=0 && x<grid.length && y>=0 && y<grid[0].length && visited[x][y]!=1 && grid[x][y]==1){
                count=dfs(grid,visited,x,y,count);
            }
        }
        return count;

    }
}



class Pair{
    int x;
    int y;
    public void Pair(int x,int y){
        this.x=x;
        this.y=y;
    }
}