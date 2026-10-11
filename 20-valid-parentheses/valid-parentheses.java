class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();

        char[] arr=s.toCharArray();

        HashMap<Character,Character> map=new HashMap<>();

        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        for(char ch:arr){
            if(map.containsKey(ch)){
                if(stack.isEmpty()) return false;

                if(stack.peek()!=map.get(ch)) return false;
                stack.pop();
            }else{
                stack.add(ch);
            }
        }
        if(!stack.isEmpty()){
            return false;
        }
        return true;
    }
}