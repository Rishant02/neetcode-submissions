class Solution {
    public boolean isValid(String s) {

        // TC: O(n) - traverse string once
        // SC: O(n) - stack may store all opening brackets

        // Intuition:
        // Opening bracket -> push
        // Closing bracket -> must match most recent opening bracket (stack top)

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            // Store opening brackets for future matching
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {

                // No opening bracket available to match
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                // Closing bracket must match stack top
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }

        // All opening brackets should be matched
        return stack.isEmpty();
    }
}