class Solution {
    public boolean isValid(String s) {

        char[] perm = s.toCharArray();
        Stack<Character> stack = new Stack<Character>();

        for (char p : perm) {
            if (p == '[' || p == '{' || p == '(') {
                stack.push(p);
            }

            else if (p == ']' || p == '}' || p == ')') {
                if (stack.isEmpty())
                    return false;
                char top = stack.peek();

                if ((p == ']' && top != '[') || (p == '}' && top != '{') || (p == ')' && top != '(')) {
                    return false;
                }

                 stack.pop();
            }

           
        }

        return stack.isEmpty();

    }
}