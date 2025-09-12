import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 벡터 합의 크기가 작은것
 * 움직인 벡터를 합해 크기가 최소
 * 모든 벡터의 합이 최소 -> 제곱
 * 모든 지렁이가 만나야함
 * 
 * 모든 벡터의 합을 구하고, 조합으로 N/2 마리를 골라 선택된 애들 좌표의 합을 구하기
 * 전체 합 - 2*(한 그룹의 벡터 합) = 백터 합
 */
public class Solution {

	static int N;
	static long min;
	static int[][] earthworm;
	static int[] total;
	static boolean[] selected;
	
	static void combination(int cnt, int idx) {
		if(idx == N) return;
		if(cnt == N / 2) {
			long sum_x = 0, sum_y = 0;
			for(int i = 0; i < N; i++) {
				if(selected[i]) {
					sum_x += earthworm[i][0];
					sum_y += earthworm[i][1];
				}
			}
			long x = total[0] - 2 *sum_x;
			long y = total[1] - 2* sum_y;
			min = Math.min(x * x + y * y, min);
			return ;
		}
		
		selected[idx] = true;
		combination(cnt+1, idx+1);
		
		selected[idx] = false;
		combination(cnt, idx+1);
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int t = 1; t <= T ;t++) { //tc
			min = Long.MAX_VALUE;
			N = Integer.parseInt(br.readLine().trim());
			earthworm = new int[N][2];
			selected = new boolean[N];
			
			total = new int[2]; // x, y
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 2; j++) {
					earthworm[i][j] = Integer.parseInt(st.nextToken());
					total[j] += earthworm[i][j];
				}
			}
			
			combination(0, 0);
			
			System.out.println("#" + t + " "+ min);
		}
	}

}
