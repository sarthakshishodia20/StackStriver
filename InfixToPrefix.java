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
                val.push(s); 
            } 
            else if (ch == '(' || op.isEmpty() || op.peek() == '(') { 
                op.push(ch);
            } 
            else if (ch == ')') {
                while (!op.isEmpty() && op.peek() != '(') { 
                    String v2 = val.pop();
                    String v1 = val.pop();
                    char o = op.pop();
                    String t = o + v1 + v2;
                    val.push(t);
                }
                if (!op.isEmpty()) op.pop(); 
            } 
            else {
                if (ch == '+' || ch == '-') {
                    while (!op.isEmpty() && op.peek() != '(') { 
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char o = op.pop();
                        String t = o + v1 + v2;
                        val.push(t);
                    }
                    op.push(ch);
                } 
                else if (ch == '*' || ch == '/') {
                    while (!op.isEmpty() && (op.peek() == '*' || op.peek() == '/')) { 
                        String v2 = val.pop();
                        String v1 = val.pop();
                        char o = op.pop();
                        String t = o + v1 + v2;
                        val.push(t);
                    }
                    op.push(ch);
                }
            }
        }
        while (!op.isEmpty()) {
            String v2 = val.pop();
            String v1 = val.pop();
            char o = op.pop();
            String t = o + v1 + v2;
            val.push(t);
        }
        System.out.print(val.peek());
    }
}
