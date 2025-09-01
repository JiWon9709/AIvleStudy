import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j], dp[i-1][j-1]) + map[i][j]
 *  
 */
public class Main {
	static int N, M;
	static int ans;
	static int[][] map, dp;	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dp = new int[N][M];
		map = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = map[0][0];

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(i == 0 && j >= 1) dp[i][j] = dp[i][j-1];
				else if(i == 0 && j == 0) continue;
				else if(i >= 1 && j == 0) dp[i][j] = dp[i-1][j];
				else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);

					if(dp[i][j] < dp[i-1][j-1])
						dp[i][j] = dp[i-1][j-1];
				}
				
				dp[i][j] += map[i][j];
			}
		}
		
		
		System.out.println(dp[N-1][M-1]);
	}
}