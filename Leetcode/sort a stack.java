package Leetcode;
import java.util.*;
class Solution {
    public void sortStack(Stack<Integer> st) {
        if(st.isEmpty()){
            return;
        }
        int num=st.pop();
        sortStack(st);
        insertNum(st,num);
    }
    public void insertNum(Stack<Integer> st,int num){
        if(st.isEmpty() || st.peek()<num){
            st.push(num);
            return;
        }
        int temp=st.pop();
        insertNum(st,num);
        st.push(temp);
    }
}
