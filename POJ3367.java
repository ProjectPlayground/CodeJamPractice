import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class POJ3367 {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int t = scanner.nextInt();
		for (int i=0;i<t;i++){
			String s = scanner.next();
			solve(s);
		}
		scanner.close();
	}
	
	public static void solve(String s){
		Stack<Node> stack = new Stack<Node>();
		
		for(int i=0;i<s.length();i++){
			Node n = new Node();
			n.value = s.charAt(i);
			n.isOp = isUpper(s.charAt(i));
			if (!n.isOp)
				stack.push(n);
			else{
				 n.right = stack.pop();
				 n.left = stack.pop();
				 stack.push(n);
			}		
		}
		LinkedList<Node> queue = new LinkedList<Node>();
		Stack<Character> st = new Stack<Character>();
		queue.add(stack.pop());
		while(!queue.isEmpty()){
			Node n = queue.removeFirst();
			if (n.left!=null)
				queue.add(n.left);
			if (n.right!=null)
				queue.add(n.right);
			
			st.push(n.value);	
		}
		
		StringBuilder sb = new StringBuilder();
		while(!st.isEmpty())
			sb.append(st.pop());
		System.out.println(sb.toString());
		
	}
	
	public static class Node{
		char value;
		boolean isOp;
		Node left;
		Node right;
		
	}
	
	public static boolean isUpper(char c){
		if ((c>='A') && (c<='Z'))
			return true;
		else
			return false;
	}
}
