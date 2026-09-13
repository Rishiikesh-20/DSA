class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int x=0;
        int y=0;

        int dx=0;
        int dy=1;

        List<Integer> result=new ArrayList<>();

        for(int i=0;i<m*n;i++){
            result.add(matrix[x][y]);
            matrix[x][y]=-101;

            if(!(x+dx>=0 && x+dx<m && y+dy>=0 && y+dy<n) || matrix[x+dx][y+dy]==-101){
                int temp=dy;
                dy=-dx;
                dx=temp;
            }
            x+=dx;
            y+=dy;
        }
        return result;
    }
}