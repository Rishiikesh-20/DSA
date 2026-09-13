class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;

        int x=-1;
        int y=-1;

        for(int i=0;i<m;i++){
            if(matrix[i][0]==0){
                x=1;
                break;
            }
        }

        for(int j=0;j<n;j++){
            if(matrix[0][j]==0){
                y=1;
                break;
            }
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    System.out.print("Hello");
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=1;i<n;i++){
            if(matrix[0][i]==0){
                for(int j=0;j<m;j++){
                    System.out.println(j+" "+i);
                    matrix[j][i]=0;
                }
            }
        }
        System.out.print("Hello");
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0){
                for(int j=0;j<n;j++){
                    System.out.println(j+" "+i);
                    matrix[i][j]=0;
                }
            }
        }

        if(y==1){
            for(int i=0;i<n;i++){
                matrix[0][i]=0;
            }
        }
        if(x==1){
            for(int i=0;i<m;i++){
                matrix[i][0]=0;
            }
        }

    }
}