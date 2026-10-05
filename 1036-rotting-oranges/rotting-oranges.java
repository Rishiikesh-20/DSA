class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
		int n=grid[0].length;
		
		Queue<int[]> queue=new LinkedList<>();
		int found=0;
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j]==2){
					queue.add(new int[]{i,j});
				}else if(grid[i][j]==1){
					found=1;
				}
			}
		}
		if(found==0) return 0;
		int time=0;
		while(!queue.isEmpty()){
			int len=queue.size();
			found=0;
			for(int i=0;i<len;i++){
				int[] node=queue.poll();
				
				int[] dirX={-1,1,0,0};
				int[] dirY={0,0,-1,1};
				
				for(int j=0;j<4;j++){
					int x=dirX[j]+node[0];
					int y=dirY[j]+node[1];
					
					if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==1){
						grid[x][y]=2;
                        found=1;
						queue.add(new int[]{x,y});
					}
				}
			}
            if(found==0) break;
			time++;
		}
		
		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid[i][j]==1) return -1;
			}
		}
		
		return time;
    }
}