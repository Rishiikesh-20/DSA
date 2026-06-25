class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();

        char[] arr=s.toCharArray();

        for(char ch:arr){
            if(ch=='{' || ch=='(' || ch=='['){
                stack.push(ch);
            }else{
                if(stack.size()==0) return false;
                char opp=stack.peek();
                if(ch=='}' && opp=='{'){
                    stack.pop();
                }else if(opp=='(' && ch==')'){
                    stack.pop();
                }else if(opp=='[' && ch==']'){
                    stack.pop();
                }else{
                    return false;
                }
            }
        } 
        if(stack.size()!=0) return false;
        return true;
    }
}