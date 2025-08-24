package Leetcode;
import java.util.*;
class Solution {
    public void reverseStack(Stack<Integer> st) {
        if(st.isEmpty()){
            return;
        }
        int num=st.pop();
        reverseStack(st);
        pushElements(st,num);
    }
    public void pushElements(Stack<Integer> st,int num){
        if(st.isEmpty()){
            st.push(num);
        }
        int temp=st.pop();
        pushElements(st,num);
        st.push(temp);
    }
}