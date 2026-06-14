class Solution {
    public boolean isMatch(String s, String p) {
        int m=s.length();
        int n=p.length();

        boolean[] prev=new boolean[n+1];
        prev[0]=true;

        for(int i=1;i<=n;i++){
            if(p.charAt(i-1)=='*'){
                prev[i]=prev[i-1];
            }
        }

        for(int i=1;i<=m;i++){
            boolean[] cur=new boolean[n+1];
            for(int j=1;j<=n;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?'){
                    cur[j]=prev[j-1];
                }else if(p.charAt(j-1)=='*'){
                    cur[j]=(cur[j-1] || prev[j]);
                }
            }
            prev=cur;
        }
        return prev[n];

    }
}