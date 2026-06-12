class Solution {
    public int longestIncreasingPath(int[][] arr) {
        int m=arr.length;
        int n=arr[0].length;

        PriorityQueue<Pair> queue=new PriorityQueue<>((a,b)->Integer.compare(b.value,a.value));
        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                queue.add(new Pair(arr[i][j],i,j));
            }
        }
        int max=0;
        while(!queue.isEmpty()){
            Pair node=queue.poll();
            int r=node.r;
            int c=node.c;
            int[] dx={-1,1,0,0};
            int[] dy={0,0,-1,1};

            for(int i=0;i<4;i++){
                int x=r+dx[i];
                int y=c+dy[i];

                if(x>=0 && x<m && y>=0 && y<n && arr[r][c]<arr[x][y]){
                    dp[r][c]=Math.max(dp[r][c],1+dp[x][y]);
                }
            }
            max=Math.max(max,dp[r][c]);
        }
        return max;

    }
}

class Pair{
    int value;
    int r;
    int c;
    Pair(int value,int r,int c){
        this.value=value;
        this.r=r;
        this.c=c;
    }
}