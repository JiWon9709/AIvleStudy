import java.awt.Point;
import java.io.*;
import java.util.*;

import javax.management.Query;

/**
 * 
 * 
 */
public class Main {
	static int parents[];
	static class Edge {
		int from;
		int to;
		int weight;
		
		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
	
	static int find(int x) {
		if(x == parents[x]) return x;
		return find(parents[x]);
	}
	
	static boolean union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		if(parentA != parentB) {
			parents[parentA] = parentB;
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int graph[][] = new int[N][N];
		int total = 0; // 총 랜선의 길이
//		ArrayList<Edge>[] list = new ArrayList[N];
		List<Edge> edgeList = new ArrayList<>();
		for(int i =0; i < N; i++) {
			char[] string = br.readLine().toCharArray(); // "abc" -> "a"
//			list[i] = new ArrayList<>();
			
			for(int j = 0; j < N; j++) {
				if(string[j] >= 'a') {
					graph[i][j] = string[j] - 'a'+1;
				} else if(string[j] >= 'A') {
					graph[i][j] = string[j] - 'A'+27;
				} else 
					graph[i][j] = string[j] - '0';
				

				total += graph[i][j];
				if(graph[i][j] == 0) continue;
//				list[i].add(new Edge(i, j, graph[i][j]));
				edgeList.add(new Edge(i, j, graph[i][j]));
			}
		}
//		for(int i =0; i < N;i++) {
//			System.out.println(Arrays.toString(graph[i]));
//		}
		
		// pq 사용?
		edgeList.sort((a, b) -> a.weight - b.weight);
		
		parents = new int[N];
		for(int i = 0; i < N; i++) {
			parents[i] = i;
		}
		
		// 하나씩 꺼내와서 네트워크 만들기
		int lan = 0;
		for(Edge e: edgeList) {
			int start = e.from;
			int end = e.to;
			int w = e.weight;
			
			if(start == end) continue;
			if(find(start) == find(end)) continue;
			union(start, end);
			lan += w;
		}
		
//		System.out.println(lan);
		int first = -1;
		boolean isconnect = true;
		for(int i = 0; i < N; i++) {
			if(first == -1) {
				first = find(i);
				continue;
			}
			if(find(first) != find(i)) {
				isconnect = false;
				break;
			}
		}
		
		if(!isconnect) System.out.println(-1);
		else System.out.println(total - lan);
	}
}
