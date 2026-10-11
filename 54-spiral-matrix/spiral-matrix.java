class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean[][] visited=new boolean[m][n];
        int x=0;
        int y=0;

        int dirX=0;
        int dirY=1;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<m*n;i++){
            list.add(matrix[x][y]);
            visited[x][y]=true;

            if(x+dirX<0 || x+dirX>=m || y+dirY<0 || y+dirY>=n || visited[x+dirX][y+dirY]){
                int temp=dirX;
                dirX=dirY;
                dirY=-temp;
            }
            x=x+dirX;
            y=y+dirY;
        }

        return list;
    }
}