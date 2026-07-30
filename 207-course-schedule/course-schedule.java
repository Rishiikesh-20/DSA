class Solution {
    public boolean canFinish(int n, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<pre.length;i++){
            adj.get(pre[i][0]).add(pre[i][1]);
        }
        boolean[] visited=new boolean[n];
        boolean[] pathVisited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(dfs(adj,visited,pathVisited,i)) return false;
            }
        }
        return true;
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,boolean[] pathVisited,int ind){
        visited[ind]=true;
        pathVisited[ind]=true;
        ArrayList<Integer> edges=adj.get(ind);
        for(int to:edges){
            if(!visited[to]){
                if(dfs(adj,visited,pathVisited,to)) return true;
            }else if(pathVisited[to]){
                return true;
            }
        }
        pathVisited[ind]=false;
        return false;
    }
}