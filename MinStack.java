import java.util.Stack;

class Solution {
    private Stack<Integer> st;
    private Stack<Integer> min;
    
    public Solution() {
        st = new Stack<>();
        min = new Stack<>();
    }

    // Add an element to the top of Stack
    public void push(int x) {
        if (st.isEmpty()) {
            st.push(x);
            min.push(x);
        } else {
            st.push(x);
            min.push(Math.min(min.peek(), x));
        }
    }

    // Remove the top element from the Stack
    public void pop() {
        if (!st.isEmpty()) {
            st.pop();
            min.pop();
        }
    }

    // Returns top element of the Stack
    public int peek() {
        if (st.isEmpty()) {
            return -1;
        }
        return st.peek();
    }

    // Finds minimum element of Stack
    public int getMin() {
        if (min.isEmpty()) {
            return -1;
        }
        return min.peek();
    }
}
