class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev=new int[n];
        int[] cur=new int[n];

        Arrays.fill(prev,1);

        for(int i=1;i<m;i++){
            for(int j=0;j<n;j++){
                int left=0;
                int top=0;
                if(j-1>=0){
                    left=cur[j-1];
                }
                top=prev[j];

                cur[j]=top+left;
            }
            prev=cur;
        }
        return prev[n-1];
    }
}