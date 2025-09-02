import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * dfs 로 하려다가
 * 최단거리가 K인것을 구해야 하기때문에!!
 */
public class Main {
	static int N, M, K, X;
	static Set<Integer> ans;
	static List<Integer>[] map;
	static boolean visited[];
	static int[] dp;
	
	static void dfs(int cnt, int n) {
		if(cnt > K) return ;
		if(cnt < dp[n]) dp[n] = cnt;
		
		for(int x: map[n]) {
			if(dp[x] > cnt +1)
				dfs(cnt+1, x);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N+1];
		ans = new HashSet<>();
		dp = new int[N+1];
		visited = new boolean[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for(int i = 0; i <= N; i++) {
			map[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		
		dfs(0, X);
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for(int idx = 0; idx <= N; idx++) {
			if(dp[idx] == K) {
				sb.append(idx).append('\n');
				flag = true;
			}
		}
		
		if(!flag) System.out.println(-1);
		else System.out.println(sb);
	}
}