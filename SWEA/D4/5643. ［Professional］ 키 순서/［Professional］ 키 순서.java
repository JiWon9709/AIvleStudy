import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			int dist[][] = new int[N+1][N+1];
			for(int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				dist[a][b] = 1; // a가 b 보다 작다
			}
			
			for(int k = 1; k <= N; k++) {
				for(int i = 1; i <= N; i++) {
					for(int j = 1; j <= N; j++) {
						// i < k && k < j 이면 i < j
						if(dist[i][k] == 1 && dist[k][j] == 1) {
							dist[i][j] = 1;						
						}
					}
				}
			}
			
			int cnt = 0; // j보다 작은 애들 i < j , j보다 큰 애들 j < k
			for(int k = 1; k <= N; k++) {
				int sum = 0;
				for(int i = 1; i <= N; i++) {
					sum += dist[k][i];
				}
				for(int j = 1; j <= N; j++) {
					sum += dist[j][k];
				}
				if(sum == N-1) cnt++;
			}
			System.out.println("#" + t + " " + cnt);
		}
	}

}
