class Solution {
    public int calculate(String s) {
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isWhitespace(ch)) continue;
            if (Character.isDigit(ch)) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--; 
                val.push(num);
            }
            else if (ch == '(') {
                op.push(ch);
            }
            else if (ch == ')') {
                while (!op.isEmpty() && op.peek() != '(') {
                    int b = val.pop();
                    int a = val.pop();
                    char o = op.pop();
                    val.push(applyOperation(o, a, b));
                }
                op.pop(); 
            }
            else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                while (!op.isEmpty() && precedence(ch) <= precedence(op.peek())) {
                    int b = val.pop();
                    int a = val.pop();
                    char o = op.pop();
                    val.push(applyOperation(o, a, b));
                }
                op.push(ch);
            }
        }
        while (!op.isEmpty()) {
            int b = val.pop();
            int a = val.pop();
            char o = op.pop();
            val.push(applyOperation(o, a, b));
        }
        return val.peek();
    }

    public static int precedence(char c) {
        if (c == '*' || c == '/') return 2;
        if (c == '+' || c == '-') return 1;
        return 0;
    }

    public static int applyOperation(char op, int a, int b) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
        }
        return 0;
    }
}
