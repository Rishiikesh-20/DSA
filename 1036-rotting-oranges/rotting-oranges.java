class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue=new LinkedList<>();
        int m=grid.length;
        int n=grid[0].length;
        int one=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }else if(grid[i][j]==1){
                    one++;
                }
            }
        }
        if(one==0){
            return 0;
        }
        int result=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                int[] node=queue.poll();

                int[] xdir={-1,1,0,0};
                int[] ydir={0,0,-1,1};

                for(int j=0;j<4;j++){
                    int x=node[0]+xdir[j];
                    int y=node[1]+ydir[j];

                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
                        one--;
                        grid[x][y]=2;
                        queue.add(new int[]{x,y});
                    }
                }
            }
            result++;
        }
        if(one!=0){
            return -1;
        }
        return result-1;
    }
}