import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	/**
	 * 가로 : bar 모양의 셀 * W개
	 * 세로 : D 두께
	 * 셀 : A=0 또는 B=1
	 * 
	 * 단면의 모든 세로 방향에서 같은 특성들의 셀들이 K개 이상 연속적으로 있는 경우 -> 성능 검사 통과
	 * 약품 투입 : A -> 모든 막을 특성 A로, B -> B로
	 * 
	 * 최소 약품 투입 횟수 = count
	 * 
	 * @param args
	 */
	private static int D, W, K, count;
	private static int[][] film; // 원본
	
	/** 열
	 * width 마다 특정 셀이 K개 만큼 연속적으로 있는지 체크하는 함수
	 */
	public static boolean check_cell(int w) {
		int prevCell = film[0][w]; // 연속으로 나오는지 체크하는 플래그
		int cnt = 1; // 연속으로 나오면 ++1
		int max_cnt = 0;
		
		for(int cur_h = 1; cur_h < D; cur_h++) {
			if(film[cur_h][w] == prevCell) {
				cnt++;
			} else {
				prevCell = film[cur_h][w];
				cnt = 1;
			}
			max_cnt = Math.max(max_cnt, cnt);
		}
		return max_cnt >= K ? true: false;
	}
	
	// 모든 열마다 성능 검사
	public static boolean check_all_width_cell() {
		for(int w = 0; w < W; w++) {
			if(!check_cell(w)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * (A, B) 약품을 height에 넣는 함수.  
	 * @param 높이, 약품종류
	 * @throws Exception
	 */
	public static void fill_med(int h, int kind) {
		for(int cur_w = 0; cur_w < W; cur_w++) {
			if(film[h][cur_w] != kind)
				film[h][cur_w] = kind;
		}
	}
	
	// 전의 투약한 셀들에 약품 투약해보기
	// 횟수 기준으로 해야하나...
	public static void backTrack(int idx, int cnt) {
		if(cnt >= count) return;
		
		if(check_all_width_cell()) {
			count = Math.min(count, cnt);
			return ;
		}
		
		if(idx >= D) return;
		
		int[] backup = film[idx].clone();
		
		// 투여 안함
		backTrack(idx + 1, cnt);
		
		// A 투약
		for(int w = 0; w< W; w++) film[idx][w] = 0;
			backTrack(idx+1, cnt+1);
		
		// B 투약
		for(int w = 0; w< W; w++) film[idx][w] = 1;
			backTrack(idx+1, cnt+1);
			
		film[idx] = backup;
	}
	
			
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		/**
		 *  입력
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			film = new int[D][W];
			for(int height = 0; height < D; height++) {
				st = new StringTokenizer(br.readLine().trim());
				for(int width = 0; width < W; width++) {
					film[height][width] = Integer.parseInt(st.nextToken());
				}
			}
			
			/**
			 * 모든 열마다 성능 검사해서 통과가 되는지 확인해보기
			 * 안되는 열이 나왔을 경우 -> 약품 투여 / count++
			 * -> 다시 모든 열마다 성능검사
			 * 
			 * 모든 높이에 대해 약품을 투여하고 체킹해보기
			 * 이유 : D 와 W의 범위가 작아서 완탐 가능할듯...?
			 */
			
			
			/**
			 *  각 행마다 약품 투여해보기
			 *  각 행마다 투여 해도 되고 안해도 됨
			 *  2*h 번 수행
			 *  투여를 어떻게 하는게 좋을까.....???
			 *  모든행에 수행한다하면, 1번째 줄에 수행 한거에 3번째줄에도 투약한게 최소일수 있음.
			 *  최악의 경우 모든 행에 약품을 투약한 경우 = 2의 W승???
			 *  
			 *  투약 횟수 마다 바뀐 셀을 저장
			 *  투약 횟수를 늘릴때마다 투약했던 셀에 다시 연산
			 */
			count = K;
			
			backTrack(0, 0);
			System.out.println("#"+test_case+" "+count);
			
		}
	}
}
