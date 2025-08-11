import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	static int n;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int cur = 1;
		StringBuilder sb = new StringBuilder();
		for(int x: arr) { // 
			if(!stack.isEmpty() && stack.peek().equals(x)) {
				stack.pop();
				sb.append('-').append('\n');
				continue;
			}
			
			if(cur > x) break;
			while(cur <= x) {
				stack.add(cur++);
				sb.append('+').append('\n');
			}
			if(stack.isEmpty()) continue;
			stack.pop();
			sb.append('-').append('\n');
		}
		
		if(!stack.isEmpty())
			System.out.println("NO");
		else System.out.println(sb);
	}
}