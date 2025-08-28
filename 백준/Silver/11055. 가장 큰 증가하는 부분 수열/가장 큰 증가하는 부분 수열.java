import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static int N;
	static int ans;
	static int[] arr, dp;	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		dp = new int[N+1];
		ans = Integer.MIN_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int j = 1; j <= N; j++) {
			arr[j] = Integer.parseInt(st.nextToken());
		}
		
		// dp[idx] = idx 까지의 인덱스 중에서 증가하는 부분수열의 합이 가장 큰 값
		for(int idx = 0; idx <= N; idx++) {
			dp[idx] = arr[idx]; // 자기자신 더하기
			for(int pivot = 1; pivot < idx; pivot++) { // 기준값보다 작을 경우, 부분집합에 추가
				if(arr[pivot] < arr[idx]) {
					dp[idx] = Math.max(dp[idx], dp[pivot] + arr[idx]);
				}
			}
		}
		
		for(int sum : dp) {
			ans = Math.max(sum, ans);
		}
		System.out.println(ans);
	}
}