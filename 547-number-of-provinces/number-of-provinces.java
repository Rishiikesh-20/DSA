class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=isConnected.length;
        for(int i=0;i<n;i++){
            ArrayList<Integer> list=new ArrayList<>();
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1){
                    list.add(j);
                }
            }
            adj.add(list);
        }
        System.out.println(adj);
        int count=0;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                System.out.println(Arrays.toString(visited));
                
                dfs(adj,visited,i);
            }
        }
        return count;
    }

    public void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int ind){
        visited[ind]=true;
        ArrayList<Integer> edges=adj.get(ind);

        for(int to:edges){
            if(!visited[to]){
                dfs(adj,visited,to);
            }
        }
    }
}