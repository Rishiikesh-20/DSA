class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {
        
        int n=arr.length;
        int[] visited=new int[pieces.length];
        int i=0;
        while(i<n){
            boolean flag=false;
            for(int j=0;j<pieces.length;j++){
                if(i<n && pieces[j][0]==arr[i]){
                    int k=0;
                    while(i<n && k<pieces[j].length){
                        if(pieces[j][k]==arr[i]){
                            i++;
                            k++;
                        }else{
                            return false;
                        }
                    }
                    flag=true;
                }
            }
            if(flag==false){
                return false;
            }
        }
        return true;
    }
}