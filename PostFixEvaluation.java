import java.util.*;

class Solution {
    public int evaluate(String[] arr) {
        Stack<Integer> val = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            String ch = arr[i];
            if (ch.length() == 1 && ch.charAt(0) >= '0' && ch.charAt(0) <= '9') {
                val.push(ch.charAt(0) - '0');
            } else {
                int v2 = val.pop();
                int v1 = val.pop();
                if (ch.equals("+")) {
                    val.push(v1 + v2);
                } else if (ch.equals("-")) {
                    val.push(v1 - v2);
                } else if (ch.equals("*")) {
                    val.push(v1 * v2);
                } else if (ch.equals("/")) {
                    val.push(v1 / v2);
                }
            }
        }
        return val.pop();
    }
}
