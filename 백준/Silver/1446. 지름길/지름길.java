//package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
	static class Node {
		private int to;
		private int weight;
		
		Node(int to, int weight){
			this.to = to;
			this.weight = weight;
		}
	}
	
	public static int dijkstra(int D, List<List<Node>> graph) {
		int[] dist = new int[D+1];
		boolean[] visited = new boolean[D+1];
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		visited[0] = true;
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight); ///
		pq.offer(new Node(0, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			visited[cur.to] = true;
			if(dist[cur.to] < cur.weight) continue;
			for(Node next: graph.get(cur.to)) {
				if(dist[next.to] > dist[cur.to] + next.weight) {
					dist[next.to] = dist[cur.to] + next.weight;
					pq.offer(new Node(next.to, dist[next.to]));
				}
			}
		}
		
		return dist[D];
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		List<List<Node>> graph = new ArrayList<>(); ////
		for(int i = 0; i< D+1; i++) {
			graph.add(new ArrayList<>());
			if(i < D) {
				graph.get(i).add(new Node(i+1, 1));
			}
		}
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			// 도착 지점이 D보다 크면 무시
			if(dest > D) continue;
			// 지름길이 더 빠른 경우 graph에 추가
			if(dest - start > w) {
				graph.get(start).add(new Node(dest, w));
			}
		}
		System.out.println(dijkstra(D, graph));
	}
}
