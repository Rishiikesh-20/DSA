class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist=new int[n];
        ArrayList<ArrayList<int[]>> edges=new ArrayList<>();

        for(int i=0;i<n;i++){
            edges.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int[] node=times[i];
            edges.get(node[0]-1).add(new int[]{node[1]-1,node[2]});
        }
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k-1]=0;

        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1]));

        pq.add(new int[]{k-1,0});

        while(!pq.isEmpty()){
            int[] node=pq.poll();
            int u=node[0];
            int w=node[1];

            for(int[] list:edges.get(u)){
                int v=list[0];
                if(dist[v]>list[1]+w){
                    dist[v]=list[1]+w;
                    pq.add(new int[]{v,dist[v]});
                }
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            max=Math.max(max,dist[i]);
        }
        return max;

    }
}