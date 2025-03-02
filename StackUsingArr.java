public class Solution{
    static class Stack {
        int size;
        int top;
        int[] arr;
        Stack(int capacity) {
            // Write your code here.
            arr=new int[capacity];
            top=-1;
            size=capacity;
        }
        public void push(int num) {
            // Write your code here.
            if(top<size-1){
                top++;
                arr[top]=num;
                // top++;
            }
            else{
                return;
            }
        }
        public int pop() {
            // Write your code here.
            if(top==-1){
                return -1;
            }
            int ans=arr[top];
            top--;
            return ans;
        }
        public int top() {
            // Write your code here.
            if(top==-1){
                return -1;
            }
            return arr[top];
        }
        public int isEmpty() {
            // Write your code here.
            if(top==-1){
                return 1;
            }
            return 0;
        }
        public int isFull() {
            // Write your code here.
            if(top==size-1){
                return 1;
            }
            return 0;
        }
    }
}
