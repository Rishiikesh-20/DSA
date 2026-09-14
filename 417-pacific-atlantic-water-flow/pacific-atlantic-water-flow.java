class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        boolean[][] pacific=new boolean[m][n];
        boolean[][] atlantic=new boolean[m][n];

        for(int i=0;i<n;i++){
            if(!pacific[0][i]){
                dfs(0,i,heights,pacific);
            }
        }
        for(int i=0;i<m;i++){
            if(!pacific[i][0]){
                dfs(i,0,heights,pacific);
            }
        }
        for(int i=0;i<m;i++){
            if(!atlantic[i][n-1]){
                dfs(i,n-1,heights,atlantic);
            }
        }
        for(int i=0;i<n;i++){
            if(!atlantic[m-1][i]){
                dfs(m-1,i,heights,atlantic);
            }
        }
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(new ArrayList<>(List.of(i,j)));
                }
            }
        }

        return result;

    }
    public void dfs(int r,int c,int[][] heights,boolean[][] visited){
        int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
        int m=heights.length;
        int n=heights[0].length;
        visited[r][c]=true;
        for(int[] temp:dir){
            int x=r+temp[0];
            int y=c+temp[1];

            if(x>=0 && x<m && y>=0 && y<n && visited[x][y]==false && heights[x][y]>=heights[r][c]){
                dfs(x,y,heights,visited);
            }
        }
    }
}