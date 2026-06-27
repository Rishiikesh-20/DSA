class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> queue=new LinkedList<>();
        boolean fresh=false;
        int freshCount=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    queue.add(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh=true;
                    freshCount++;
                }
            }
        }
        if(fresh==false){
            return 0;
        }
        int count=0;
        while(!queue.isEmpty() && freshCount!=0){
            int l=queue.size();
            for(int i=0;i<l;i++){
                int[] arr=queue.poll();
                //top,right,down,left
                int[] xarr=new int[]{arr[0]-1,arr[0],arr[0]+1,arr[0]};
                int[] yarr=new int[]{arr[1],arr[1]+1,arr[1],arr[1]-1};
                
                for(int j=0;j<4;j++){
                    if(xarr[j]>=0 && xarr[j]<m && yarr[j]>=0 && yarr[j]<n){
                        if(grid[xarr[j]][yarr[j]]==1){
                            grid[xarr[j]][yarr[j]]=2;
                            queue.add(new int[]{xarr[j],yarr[j]});
                            freshCount-=1;
                        }
                    }
                }
            }
            count++;
        }
        if(freshCount==0){
            return count;
        }
        return -1;
    }
}