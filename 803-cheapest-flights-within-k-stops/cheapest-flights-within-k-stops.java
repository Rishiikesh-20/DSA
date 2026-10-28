class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<int[]> queue = new LinkedList<>();

        ArrayList<ArrayList<int[]>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < flights.length; i++) {
            list.get(flights[i][0]).add(new int[] { flights[i][1], flights[i][2] });
        }

        queue.add(new int[] { 0, src, 0 });
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            ArrayList<int[]> temp = list.get(node[1]);
            int count=node[0];
            int covered=node[2];
            for (int i = 0; i < temp.size(); i++) {
                int v=temp.get(i)[0];
                int d=temp.get(i)[1];

                if(dist[v]==Integer.MAX_VALUE || dist[v]>=covered+d){
                    if(count<k || v==dst){
                        dist[v]=covered+d;
                        queue.add(new int[]{count+1,v,covered+d});
                    }
                }
                
            }
        }

        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
}
// class Triplet{
//     int node;
//     int dist;
//     int stops;

//     Triplet(int stops,int node,int dist){
//         this.node=node;
//         this.dist=dist;
//         this.stops=stops;
//     }
// }