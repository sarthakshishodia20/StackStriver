class Solution {
    static String preToPost(String pre_exp) {
        // code here
        Stack<String> val=new Stack<>();
        for(int i=pre_exp.length()-1;i>=0;i--){
            char ch=pre_exp.charAt(i);
            if(Character.isLetter(ch)){
                val.push(ch+"");
            }
            else{
                if(val.size()<2){
                    return "Invalid Expression";
                }
                String v1=val.pop();
                String v2=val.pop();
                char o=ch;
                String t=v1+v2+o;
                val.push(t);
            }
        }
        return val.peek();
    }
}
