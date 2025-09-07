package Leetcode;

class Solution {
    public int minOperations(String s) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++){
            arr[(int)s.charAt(i)-97]++;
        }
        int op=0;
        for(int i=1;i<26;i++){
            if(arr[i]>0){
                op=26-i;
                break;
            }
        }
        return op;
    }
}
