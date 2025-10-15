import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		
		int n1 = str1.length;
		int n2 = str2.length;
		int [][] dp = new int[n1][n2];
		
		int max_len = 0;
		for(int i = 0; i < n1; i++) {
			for(int j = 0; j < n2; j++) {
				if(str1[i] == str2[j]) {
					if(j == 0 || i ==0) dp[i][j] = 1;
					else
						dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					if(i == 0 && j == 0) dp[i][j] = 0;
					else if (i == 0) dp[i][j] = dp[i][j-1];
					else if(j == 0) dp[i][j] = dp[i-1][j];
					else 
						dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
				max_len = Math.max(max_len, dp[i][j]);
			}
		}
		System.out.println(max_len);
		
		Stack<Character> stack = new Stack<>();
		int idx1 = n1-1;
		int idx2 = n2-1;
		
		while(idx1 >= 0 && idx2 >= 0) {
			if(str1[idx1] == str2[idx2]) {
				stack.push(str1[idx1]);
				idx1--;
				idx2--;
			}
			else if(idx1 > 0 && idx2 > 0) {
				if(dp[idx1-1][idx2] > dp[idx1][idx2-1]) {
					idx1--;
				}
				else {
					idx2--;
				}
			}
			else {
				if(idx1 == 0) idx2--;
				else idx1--;
			}
		}
		
//		while(max_len > 0 && idx1 >= 0 && idx2 >= 0) {
//			int found = -1; 
//			
//			for(int i = idx2; i >= 0; i--) {
//				if(str2[i] == str1[idx1]) {
////					idx1--;
//					found = i;
//					break;
//				}
//			}
//			
//			// 못찾았을 경우
//			if(found == -1) {
//				idx1--;
//				continue;
//			}
//			
//			stack.push(str1[idx1]);
//			max_len--;
//			idx1--;
////			idx2--;
//			idx2 = found - 1;
//		}
		
		String s = "";
		while(!stack.isEmpty()) {
			s += stack.pop();
		}
		System.out.println(s);
	}
	
}
