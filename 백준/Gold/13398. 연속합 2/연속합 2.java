import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
// 수 하나 제거 가능, 제거 안해도 됨
// 연속된 몇개의 수를 선택해서 합 구하기
// 전역 최소 삭제가 최적이 아닐수도 있기 때문에 
// 현재 i를 삭제 한경우의 dp 배열을 하나더 생성

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int []arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n];
		int[] del_dp = new int[n];
		
		dp[0] = arr[0];
		del_dp[0] = -1001;
		int ans = dp[0];
		
		for(int idx = 1; idx < n; idx++) {
			// 삭제 안했을때
			// 끝이 idx 인 경우만
			dp[idx] = Math.max(dp[idx-1] + arr[idx], arr[idx]);
			
			
			// 현재 idx를 삭제 했을때
			del_dp[idx] = Math.max(del_dp[idx -1] + arr[idx], dp[idx-1]);
			ans = Math.max(ans, Math.max(dp[idx], del_dp[idx])); 
		}
//		System.out.println(Arrays.toString(del_dp));
		System.out.println(ans);

	}

}
