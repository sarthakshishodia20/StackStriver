import java.util.Stack;

class Main {
    public static void main(String[] args) {
        String str = "9-(5+3)*4/6";
        Stack<String> val = new Stack<>();
        Stack<Character> op = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            int ascii = (int) ch;

            if (ascii >= 48 && ascii <= 57) {
                String s = "" + ch;
                val.push(s); // Fixed: `val.push(ch);` changed to `val.push(s);`
            } 
            else if (ch == '(' || op.isEmpty() || op.peek() == '(') { // Fixed: `op.size() == 0` to `op.isEmpty()`
                op.push(ch);
            } 
            else if (ch == ')') {
                while (!op.isEmpty() && op.peek() != '(') { // Fixed: added `!op.isEmpty()` to avoid peek() on empty stack
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    String t = v1+v2+o;
                    val.push(t);
                }
                if (!op.isEmpty()) op.pop(); // Fixed: Ensure `(` exists before popping
            } 
            else {
                if (ch == '+' || ch == '-') {
                    while (!op.isEmpty() && op.peek() != '(') { // Fixed: Handle precedence properly
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char o = op.pop();
                        String t = v1 + v2+o;
                        val.push(t);
                    }
                    op.push(ch);
                } 
                else if (ch == '*' || ch == '/') {
                    while (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) { // Fixed: Ensure multiplication/division precedence
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char o = op.pop();
                        String t = v1 + v2+o;
                        val.push(t);
                    }
                    op.push(ch);
                }
            }
        }

        while (!op.isEmpty()) { // Fixed: Ensure remaining operators are processed correctly
            String v2 = val.pop();
            String v1 = val.pop();
            char o = op.pop();
            String t = v1 + v2+o;
            val.push(t);
        }

        System.out.print(val.peek());
    }
}
