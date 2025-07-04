import java.util.* ;
import java.io.*; 
public class Solution {
	public static int calculateScore(ArrayList<String> matchResult, int n) {
		// Write your code here.
		Stack<Integer> s=new Stack<>();
		for(int i=0;i<matchResult.size();i++){
			String str=matchResult.get(i);
			if(str.equals("+")){
				int b=s.pop();
				int a=s.pop();
				int sum=a+b;
				s.push(a);
				s.push(b);
				s.push(sum);
			}
			else if(str.equals("C")){
				if(!s.isEmpty()){
					s.pop();
				}
			}
			else if(str.equals("D")){
				int num=s.peek()*2;
				s.push(num);
			}
			else{
				int num=Integer.parseInt(str);
				s.push(num);
			}
		}
		int score=0;
		while(!s.isEmpty()){
			score+=s.pop();
		}
		return score;
	}
}

