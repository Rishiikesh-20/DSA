class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] visited=new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(visited[i],-1);
        }
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(visited[i][j]==-1 && grid[i][j]=='1'){
                    count++;
                    dfs(grid,visited,i,j,m,n);
                }
            }
        }
        return count;
    }
    public void dfs(char[][] grid,int[][] visited,int x,int y,int m,int n){
        visited[x][y]=1;
        int[] xdir={-1,1,0,0};
        int[] ydir={0,0,-1,1};

        for(int i=0;i<4;i++){
            int r=x+xdir[i];
            int c=y+ydir[i];

            if(r>=0 && r<m && c>=0 && c<n && visited[r][c]==-1 && grid[r][c]=='1'){
                dfs(grid,visited,r,c,m,n);
            }
        }
    }
}