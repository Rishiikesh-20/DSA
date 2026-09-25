class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        int start=intervals[0][0];
        int end=intervals[0][1];
        int n=intervals.length;
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        for(int i=1;i<n;i++){
            if(end>=intervals[i][0] && end<intervals[i][1]){
                end=intervals[i][1];
            }else if(end<intervals[i][1]){
                list.add(new ArrayList<>(List.of(start,end)));
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        list.add(new ArrayList<>(List.of(start,end)));

        int[][] result=new int[list.size()][2];

        for(int i=0;i<list.size();i++){
            result[i][0]=list.get(i).get(0);
            result[i][1]=list.get(i).get(1);
        }
        return result;
    }
}