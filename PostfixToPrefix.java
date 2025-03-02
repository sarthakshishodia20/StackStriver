import java.util.*;

class Solution {
    static String postToPre(String post_exp) {
        Stack<String> val = new Stack<>();
        
        for (int i = 0; i < post_exp.length(); i++) {
            char ch = post_exp.charAt(i);
            
            if (Character.isLetter(ch)) {  
                val.push(ch + "");
            } else { 
                if (val.size() < 2) {
                    return "Invalid Expression"; 
                }
                String v2 = val.pop();
                String v1 = val.pop();
                val.push(ch + v1 + v2); 
            }
        }
        
        return val.peek(); 
    }
}
