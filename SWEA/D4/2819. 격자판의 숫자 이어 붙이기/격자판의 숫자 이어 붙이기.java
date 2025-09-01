import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 동서남북
 * 서로 다른 7자리수를 만드는 방법 
 * 
 * 
 * dfs
 * cnt == 7
 * 
 * 
 */
public class Solution {

	static Set<String> set = new HashSet<>();
	static int T, ans;
	static int[][] map;
	static int dx[] = {0, 0, -1, 1};
	static int dy[] = {-1, 1, 0, 0};
	
	static boolean is_valid(int x, int y) {
		if(x >= 0 && x < 4 && y >= 0 && y < 4) return true;
		return false;
	}
	
	static void dfs(int cnt, String num, int x, int y) {
		if(cnt == 6) {
			set.add(num);
			return ;
		}
		
		num += map[x][y];
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(is_valid(nx, ny)) {
				dfs(cnt+1, num + map[nx][ny], nx, ny);
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		map = new int[4][4];
		
		for(int t = 1; t <= T; t++) {
			set.clear();
			for(int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 4; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for(int i = 0; i < 4; i++) {
				for(int j =0; j < 4; j++) {
					dfs(0, "", i, j);
				}
			}
			System.out.println("#" + t +" " + set.size());
		}
	}

}
