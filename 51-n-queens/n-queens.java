class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result=new ArrayList<>();
        int[] cur=new int[n];
        // HashSet<Integer> set=new HashSet<>();
        backTrack(0,n,cur,result);
        return result;
    }

    public void backTrack(int row,int n,int[] cur,List<List<String>> result){
        if(row==n){
            List<String> current=new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder s=new StringBuilder();   
                for(int j=0;j<n;j++){
                    if(cur[i]==j){
                        s.append('Q');
                    }else{
                        s.append('.');
                    }
                } 
                current.add(s.toString());
            }
            result.add(current);
            return;
        }

        for(int i=0;i<n;i++){
            int flag=0;
            for(int j=0;j<row;j++){
                if((row-j)==Math.abs(i-cur[j]) || i==cur[j]){
                    flag=1;
                    break;
                }
            }
            if(flag==1) continue;
            cur[row]=i;
            backTrack(row+1,n,cur,result);
        }
    }
}