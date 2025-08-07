package Leetcode;
class Solution {
    public boolean rotateString(String s, String goal) {
    
    String a=s+s;

    if(s.length()!=goal.length()){
        return false;
    }

    if(a.contains(goal)){
        return true;
    }
    return false;

    }
}