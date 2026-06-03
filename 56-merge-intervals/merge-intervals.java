class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            return Integer.compare(a[0],b[0]);
        });
        List<List<Integer>> list=new ArrayList<>();
        int n=intervals.length;
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int i=1;i<n;i++){
            if(intervals[i][0]<=end){
                if(intervals[i][1]>end){
                    end=intervals[i][1];
                }
            }else{
                list.add(List.of(start,end));
                start=intervals[i][0];
                end=intervals[i][1];
            }
        }
        list.add(List.of(start,end));

        int len=list.size();

        int[][] result=new int[len][2];

        for(int i=0;i<len;i++){
            result[i][0]=list.get(i).get(0);
            result[i][1]=list.get(i).get(1);
        }
        return result;
    }
}