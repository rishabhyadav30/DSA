class Solution {
    public boolean isValid(String s) {
        Stack <Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && ch == ')' && st.peek()=='(') st.pop();
            else if(!st.isEmpty() && ch=='}' && st.peek()=='{') st.pop();
            else if(!st.isEmpty() && ch==']' && st.peek()=='[') st.pop();
            else st.push(ch);
        }
        if(st.isEmpty()){
            return true;
        }
        return false;
    }
}