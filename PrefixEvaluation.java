class Solution {
    public int evaluate(String[] arr) {
        Stack<Integer> val = new Stack<>();
        for (int i = arr.length-1; i>=0; i--) {
            String ch = arr[i];

            // Fix: Handle negative numbers properly
            try {
                int num = Integer.parseInt(ch);  
                val.push(num);
            } catch (NumberFormatException e) {
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
