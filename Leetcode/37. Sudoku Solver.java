package Leetcode;
import java.util.*;
class Solution {
    public void solveSudoku(char[][] board) {
        ArrayList<Pair> arr=new ArrayList<>();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.'){
                    arr.add(new Pair(i,j));
                }
            }
        }
        backTrack(board,arr,0);
    }
    public boolean backTrack(char[][] board,ArrayList<Pair> arr,int i){
        if(i==arr.size()){
            return true;
        }
        Pair v=arr.get(i);
        for(int j=1;j<=9;j++){
            if(verify(board,v,j)){
                board[v.i][v.j]=(char)(j+'0');
                if(backTrack(board,arr,i+1)){
                    return true;
                }
                board[v.i][v.j]='.';
            }
        }
       
        return false;
    }
    public boolean verify(char[][] board,Pair v,int value){
        int i=v.i;
        int j=v.j;
        char val = (char) (value + '0');
        for(int k=0;k<9;k++){
            if(board[i][k]==val){
                return false;
            }
            if(board[k][j]==val){
                return false;
            }
        }
        int row=i-i%3;
        int col=j-j%3;

        for(int k=row;k<row+3;k++){
            for(int l=col;l<col+3;l++){
                if(board[k][l]==val){
                    return false;
                }
            }
        }
        return true;
    }
}
class Pair{
    int i;
    int j;
    Pair(int i,int j){
        this.i=i;
        this.j=j;
    }
}
