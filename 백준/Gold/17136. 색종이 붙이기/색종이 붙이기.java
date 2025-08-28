import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N = 10;
	static int ans;
	static int[] paper = {0, 5, 5, 5, 5, 5}; // 사이즈별로 5장씩
	static int[][] board; // 사이즈별로 5장씩
	static boolean[] visited;
	
	static boolean is_possible(int x, int y, int size) {
		if(x + size > 10 || y + size > 10) return false;
		for(int i = x; i < x+size ; i++) {
			for(int j = y; j < y +size; j++) {
				if(board[i][j] == 0) return false;
			}
		}
		return true;
	}
	
	static void attach(int x, int y, int size, int flip) {
		for(int i = x; i < x+size ; i++) {
			for(int j = y; j < y +size; j++) {
				board[i][j] = flip ;
			}
		}
	}
	
	static void dfs(int cnt, int xy) {
//		System.out.println(xy);
		if(xy == 100) {
			ans = Math.min(ans, cnt);
			return;
		}
		
		if(ans <= cnt) return ;
		
		int x = xy / 10;
		int y = xy % 10;
		
		if(board[x][y] == 1) {
//			System.out.println(x + ", " + y);
			// 종이 사이즈별로 붙여보기. 큰것부터 시작
			for(int size = 5; size >=1; size--) {
				if(paper[size] > 0 && is_possible(x, y, size)) {
					paper[size]--;
					attach(x, y, size, 0); // 붙이기
					dfs(cnt+1, xy+1); // 붙인만큼 옆으로 이동해서 다시 찾기
					attach(x, y, size, 1); // 다시 떼기
					paper[size]++;
				}
			}
		}
		else {
			dfs(cnt, xy+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[N][N];
		ans = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 0);
			
		if(ans == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(ans);
	}
}