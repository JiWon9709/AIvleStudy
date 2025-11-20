import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, day;
	static int[] parent;
	public static class edge {
		private int start, end, t;

		public edge(int start, int end, int t) {
			super();
			this.start = start;
			this.end = end;
			this.t = t;
		}
	}
	public static void union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px > py) {
			parent[px] = py;
		}
		else {
			parent[py] = px;
		}
	}
	
	public static int find(int x) {
		if(x == parent[x])
			return x;
		else return find(parent[x]);
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
 		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		PriorityQueue<edge> list = new PriorityQueue<>(
				(a, b) -> a.t - b.t);
		int s, e, t;
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			list.add(new edge(s, e, t));
		}
		
		day = 1;
		parent = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parent[i] = i;
		}
		
		while(!list.isEmpty()){
			edge cur = list.poll();
			int start = cur.start;
			int end = cur.end;
			int d = cur.t;
			
			if(d == day) {
				if(find(start) != find(end)) {
					union(start, end);
					day++;
				}
			} else break;
		}
		
		
		System.out.println(day);
	}
}
