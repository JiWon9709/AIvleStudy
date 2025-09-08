import java.awt.Point;
import java.io.*;
import java.util.*;


public class Main {
	static int[] parents;
	
	static int find(int x) {
		if(parents[x] == x) return x;
		return find(parents[x]);
	}
	
	static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa != pb) {
			if(pa > pb) {
				parents[pa] = pb;
			}
			else parents[pb] = pa;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] list = new int[N+1][N+1];
		parents = new int[N+1];
		for(int i = 0; i<= N; i++) {
			parents[i] = i;
		}
		
		for(int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				list[i][j] = Integer.parseInt(st.nextToken());
				if(list[i][j] == 1) {
					union(i, j);
				}
			}
		}
		
		int []travel = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			travel[i] = Integer.parseInt(st.nextToken());
		}
		
		int p = find(travel[0]);
		boolean flag = false;
		for(int idx = 1; idx < M; idx++) {
			if(p != find(travel[idx])) {
				flag = true;
				break;
			}
		}
		
		if(!flag) System.out.println("YES");
		else System.out.println("NO");
	}
}