import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int N , B, height;
	private static int[] S;
	
	public static void backTrack(int idx, int h_sum) {
		if(idx >= N) {
			if(h_sum >= B && Math.abs(height - B) > Math.abs(h_sum - B))
				height = h_sum;
			//System.out.println(height);
			return;
		}
			
		// S를 포함한 경우
		backTrack(idx+1, h_sum+S[idx]);
		
		// S를 포함 안한 경우
		backTrack(idx+1, h_sum);
		
		return ;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			S = new int[N];
			for(int i = 0; i < N; i++) {
				S[i] = Integer.parseInt(st.nextToken());
			}
			
			height = 0;
			backTrack(0, 0);
			
			System.out.println("#" + t + " " + Math.abs(height - B));
		}
		
		
		

	}

}
