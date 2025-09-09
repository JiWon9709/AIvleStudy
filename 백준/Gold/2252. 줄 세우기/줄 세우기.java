import java.awt.Point;
import java.io.*;
import java.util.*;

import javax.management.Query;

public class Main {
	static int N, M;
	static int[] degree;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		degree = new int[N+1];
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for(int i = 0; i <= N; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			list.get(from).add(to);
			degree[to]++;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		// 진입차수가 0인 애들부터 넣기
		for(int i = 1; i <= N; i++) {
			if(degree[i] == 0) q.add(i);
		}
		
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			sb.append(cur).append(" ");
			
			for(int next: list.get(cur)) {
				if(degree[next] == 0) continue;
				degree[next]--;
				if(degree[next] == 0)
					q.add(next);
			}
		}
		
		System.out.println(sb);
	}
}
