class Solution {
    public int maxProduct(int[] arr) {
        int n=arr.length;
        Arrays.sort(arr);

        return Math.max((arr[n-1]-1)*(arr[n-2]-1),(arr[0]-1)*(arr[1]-1));
    }
}