import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[] = new int[n];
		dp[0] = 1;
		int best = 1; // dp 최대값, 0으로 하면 2번째 for문에서 내림차순인 배열일때 출력안함

		for(int i = 1; i < n; i++) {
			dp[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					dp[i] = Math.max(dp[i], dp[j]+1);	
				}
				best = Math.max(best, dp[i]);
			}
		}
		System.out.println(best);
//		System.out.println(Arrays.toString(dp));
		String ans = "";
		

		Stack<Integer> stack = new Stack<>();
		int last = Integer.MAX_VALUE; // 
		
		for(int i = n-1; i >= 0; i--) {
			if(best == dp[i] && last > arr[i]) {
				stack.push(arr[i]);
				best--;
				last = arr[i];
			}
		}
		
		while(!stack.isEmpty()) {
			ans += stack.pop();
			ans += " ";
		}
		
		System.out.println(ans);
	}
}

//5
//50 40 10 30 60