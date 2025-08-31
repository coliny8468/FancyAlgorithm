class Solution {
    public String removeStars(String s) {
        
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
            if (c != '*') {
                stack.push(c);
            } else if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.insert(0, stack.pop());
        }

        return sb.toString();
    }
}
