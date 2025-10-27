import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int [][] graph;
	static int min, N, K;
	
	public static void main(String[] args) throws IOException {
	    // TODO Auto-generated method stub
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    K = Integer.parseInt(st.nextToken());
	    
	    graph = new int[N][N];
	    for(int i = 0; i < N; i++) {
	        st = new StringTokenizer(br.readLine());
	        for(int j = 0; j < N; j++) {
	            graph[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
//	    int max = 1001;
//	    int[][] d = new int[N][N];
//	    
//	    for(int i = 0; i < N; i++) {
//	        Arrays.fill(d[i], max);
//	        d[i][i] = 0;
//	    }
	    
	    for(int k = 0; k < N; k++) { // 
	        for(int i = 0; i < N; i++) { // 
	            for(int j = 0; j < N; j++) { // 
	            	graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
	            }
	        }
	    }
	    
	    visited = new boolean[N];
	    visited[K] = true;
	    min = Integer.MAX_VALUE;
	    
	    dfs(K, 0, 0);
	    
//	    for(int i = 0; i < N; i++) {
//	        System.out.println(Arrays.toString(graph[i]));
//	    }
	    
	    System.out.println(min);
	}
	
	static void dfs(int start, int val, int cnt) {
		if(cnt == N-1) {
			min = Math.min(min, val);
		}
		
		for(int i = 0; i < N; i++) {
			if(!visited[i]) {
				visited[i] = true;
//				System.out.println("dfs " + start + " -> " + i);
				dfs(i, val+graph[start][i], cnt+1);
				visited[i] = false;
			}
		}
		
	}
}
