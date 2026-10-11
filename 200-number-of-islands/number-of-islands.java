class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==false && grid[i][j]=='1'){ dfs(grid,visited,i,j);count++;}  
            }
        }
        return count;
    }
    void dfs(char[][] grid,boolean[][] visited,int x,int y){
        int m=grid.length;
        int n=grid[0].length;
        visited[x][y]=true;

        int[] dirX={-1,1,0,0};
        int[] dirY={0,0,-1,1};

        for(int i=0;i<4;i++){
            int varX=x+dirX[i];
            int varY=y+dirY[i];

            if(varX>=0 && varX<m && varY>=0 && varY<n && grid[varX][varY]=='1' && visited[varX][varY]==false){
                dfs(grid,visited,varX,varY);
            }
        }
    }
}