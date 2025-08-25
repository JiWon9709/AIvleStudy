import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	/**
	 * 0 ~ N-1번 친구
	 * a - b 친구
	 * b - c, c - d, d - e가 친구인 관계가 있는 경우 1 아니면 0
	 * 
	 * dfs(int depth)
	 * depth = 5 일 경우 return 1
	 * 0번부터 친구관계인 리스트를 가져와서 depth+1 하면서 친구 관계 찾기
	 */
	
	static int N, M, a, b;
	static ArrayList<ArrayList<Integer>> friend = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	static boolean flag = false;
	static boolean[] visited;
	
	public static void dfs(int n, int depth) {
		if(depth == 5 || flag) {
			flag = true;
			return ;
		}
		
		visited[n] = true;
		for(int x: friend.get(n)) {
			if(!visited[x]) {
				dfs(x, depth+1);
			}
		}
		visited[n] = false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++)
			friend.add(new ArrayList<>());
		visited = new boolean[N];
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()); b = Integer.parseInt(st.nextToken());
			
			friend.get(a).add(b);
			friend.get(b).add(a);
		}
		
		for(int i = 0; i < N; i++) {
			dfs(i, 1);
			if(flag) {
				sb.append(1); 
				break;
			}
		}
			
		
		if(!flag) sb.append(0);
		System.out.println(sb);
	}
}