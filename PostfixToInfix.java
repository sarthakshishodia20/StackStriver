class Solution {
    static String postToInfix(String exp) {
        Stack<String> val = new Stack<>();
        
        for (int i = 0; i < exp.length(); i++) {
            char ch = exp.charAt(i);
            if (Character.isLetterOrDigit(ch)) { 
                val.push(ch + "");
            } else { 
                if (val.size() < 2) {
                    return "InvalidExpression";
                }
                String v2 = val.pop(); 
                String v1 = val.pop(); 
                val.push("(" + v1 + ch + v2 + ")"); 
            }
        }
        
        return val.peek(); 
    }
}
