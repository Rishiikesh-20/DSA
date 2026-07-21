class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m=grid.length;
        int n=grid[0].length;

        int[] arr=new int[m*n];
        int ind=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                arr[ind++]=grid[i][j];
            }
        }

        k=k%(m*n);
        int l=0;
        int r=m*n-k-1;

        while(l<r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }

        l=m*n-k;
        r=m*n-1;

        while(l<r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }


        l=0;
        r=m*n-1;

        while(l<r){
            int temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;
            l++;
            r--;
        }

        List<List<Integer>> result=new ArrayList<>();
        ind=0;
        for(int i=0;i<m;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<n;j++){
                list.add(arr[ind++]);
            }
            result.add(list);
        }

        return result;

    }
}