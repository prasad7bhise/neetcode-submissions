class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else {
                // If closing bracket comes up and stack is empty OR doesn't match
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        // Valid only if all opened brackets were properly closed
        return stack.isEmpty();
    }
}
