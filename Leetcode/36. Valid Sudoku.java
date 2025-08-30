package Leetcode;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            int[] arr=new int[18];
            for(int j=0;j<9;j++){
                int v1=board[i][j]!='.'?Integer.parseInt(String.valueOf(board[i][j])):-1;
                int v2=board[j][i]!='.'?Integer.parseInt(String.valueOf(board[j][i])):-1;
                if(v1>=0 && arr[v1-1]>0){
                    return false;
                }else if(v1>=0 && v1<=9){
                    arr[v1-1]++;
                }
                if(v2>=0 && arr[9+(v2-1)]>0){
                    return false;
                }else if(v2>=0 && v2<=9){
                    arr[9+(v2-1)]++;
                }
            }
        }
        for(int i=0;i<3;i++){
            int[] arr=new int[27];
            for(int j=0;j<3;j++){
                for(int k=0;k<3;k++){
                    int v1=board[j+i*3][k]!='.'?Integer.parseInt(String.valueOf(board[j+i*3][k])):-1;
                    int v2=board[j+i*3][k+3]!='.'?Integer.parseInt(String.valueOf(board[j+i*3][k+3])):-1;
                    int v3=board[j+i*3][k+6]!='.'?Integer.parseInt(String.valueOf(board[j+i*3][k+6])):-1;

                    if(v1>=0 && arr[v1-1]>0){
                        return false;
                    }else if(v1>=0 && v1<=9){
                        arr[v1-1]++;
                    }
                    if(v2>=0 && arr[9+(v2-1)]>0){
                        return false;
                    }else if(v2>=0 && v2<=9){
                        arr[9+(v2-1)]++;
                    }
                    if(v3>=0 && arr[18+(v3-1)]>0){
                        return false;
                    }else if(v3>=0 && v3<=9){
                        arr[18+(v3-1)]++;
                    }
                }   
            }
        }

        return true;
    }
}
