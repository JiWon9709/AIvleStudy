import java.awt.Point;
import java.io.*;
import java.util.*;

import javax.management.Query;

public class Main {
	static int N, M , cnt;
	static int min;
	static int[] node_gender, parents;
	static boolean[] visited;
	static List<Edge> edgelist;
	
	static class Edge {
		int from;
		int to;
		int weight;
		
		
		@Override
		public String toString() {
			return "Edge [from=" + from + ", to=" + to + ", weight=" + weight + "]";
		}


		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	static void union(int x, int y) {
		int pa = find(x);
		int pb = find(y);
		
		if(pa != pb) {
			if(pa < pb)
				parents[pb] = pa;
			else parents[pa] = pb;
		}
	}
	
	static int find(int x) {
		if(parents[x] == x) return x;
		return find(parents[x]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		node_gender = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			if(st.nextToken().equals("M")) node_gender[i] = 0; // 남자
			else node_gender[i] = 1; // 여자
		}
		
		edgelist = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			edgelist.add(new Edge(start, end, w));
		}
		
		Collections.sort(edgelist, (a, b) -> a.weight - b.weight);
		
		parents = new int[N+1];
		for(int i = 1; i <= N; i++) {
			parents[i] = i;
		}
		
		cnt = 0;
		min = 0;
		for(int i = 0; i < edgelist.size(); i++) {
			Edge e = edgelist.get(i);
//			System.out.println(e.toString());
			int start = e.from;
			int end = e.to;
			int w = e.weight;
			
			if(node_gender[start] != node_gender[end] && find(start) != find(end)) {
				min += w;
				cnt++;
				union(start, end);
			}
		}
		
		if(cnt == N-1) System.out.println(min);
		else System.out.println(-1);
	}
}
