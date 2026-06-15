class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        int[] cur=new int[n];
        HashSet<Integer> set=new HashSet<>();
        backTrack(0,n,cur,result,set);
        return result;
    }

    public void backTrack(int row,int n,int[] cur,List<List<String>> result,HashSet<Integer> set){
        if(row==n){
            List<String> list=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder str=new StringBuilder();
                for(int j=0;j<n;j++){
                    if(cur[i]==j){
                        str.append('Q');
                    }else{
                        str.append('.');
                    }
                }
                list.add(str.toString());
            }
            result.add(list);
            return;
        }
        for(int i=0;i<n;i++){
            boolean valid = true;

            for(int r=0; r<row; r++){
                if(Math.abs(r-row) == Math.abs(cur[r]-i)){
                    valid = false;
                    break;
                }
            }
            if(!valid) continue;
            if(set.contains(i)){
                continue;
            }
            cur[row]=i;
            set.add(i);
            backTrack(row+1,n,cur,result,set);
            set.remove(i);
        }
    }
}