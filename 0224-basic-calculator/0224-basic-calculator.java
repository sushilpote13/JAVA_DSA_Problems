class Solution {
    public int calculate(String s) {
        int result = 0;
        int num = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // If digit
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // If '+'
            else if (ch == '+') {
                result += sign * num;
                num = 0;
                sign = 1;
            }

            // If '-'
            else if (ch == '-') {
                result += sign * num;
                num = 0;
                sign = -1;
            }

            // If '('
            else if (ch == '(') {

                // Save current result and sign
                stack.push(result);
                stack.push(sign);

                // Start fresh calculation inside bracket
                result = 0;
                sign = 1;
            }

            // If ')'
            else if (ch == ')') {

                // Add the last number inside bracket
                result += sign * num;
                num = 0;

                // Get sign before '('
                int previousSign = stack.pop();

                // Get result before '('
                int previousResult = stack.pop();

                result = previousResult + previousSign * result;
            }

            // Spaces are automatically ignored
        }

        // Add the final number
        result += sign * num;

        return result;
    }
}