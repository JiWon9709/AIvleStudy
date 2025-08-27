import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 트리의 지름 = 임의의 두점 사이의 거리중 가장 긴것
 * arraylist<[node, weight]>[]
 * 
 * 모든 경우의 수를 찾아야함.
 * bfs : 두점 사이의 간선의 값이 가장 커야함
 * dist[] = 비교할 배열 필요
 * 
 */

public class Main {
	static int V, r;
	static ArrayList<int[]>[] tree;
	static int[] dist;
	static boolean[] visited;
	
	static void bfs(int node) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(node);
		visited[node] = true;
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int[] n : tree[cur]) {
					if(!visited[n[0]]) {
						visited[n[0]] = true;
						dist[n[0]] = dist[cur] + n[1];
						q.add(n[0]);
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		tree = new ArrayList[V+1];
		for(int i = 1; i <=V; i++) {
			tree[i] = new ArrayList<int[]>();
		}
		
		for(int i = 1; i <= V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			
			while(true) {
				int finish = Integer.parseInt(st.nextToken());
				if(finish == -1) break;
				tree[v].add(new int[] {finish, Integer.parseInt(st.nextToken())});
			}
		}
		
		
		dist = new int[V+1];
		visited = new boolean[V+1];
		bfs(1);
		int max_idx = 1;
		for(int i = 2; i <= V; i++) {
			max_idx = dist[max_idx] > dist[i] ? max_idx : i;
		}
		
		r = 0;
		dist = new int[V+1];
		visited = new boolean[V+1];
		bfs(max_idx);
		for(int i = 1; i <= V; i++) {
			r = Math.max(r,  dist[i]);
		}
		System.out.println(r);
	}
}