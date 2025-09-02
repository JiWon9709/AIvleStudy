import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int a, b, n, m;
//	static Set<Integer> ans;
//	static List<Integer>[] arr;
//	static boolean visited[];
	static int[] parent;
	
	static int find(int x) {
		if(parent[x] != x) parent[x] = find(parent[x]);
		return parent[x];
	}
	
	static void union(int x, int y) {
		int parentA = find(x);
		int parentB = find(y);
		
		if(parentA == parentB) return ;
		
		if(parentA != parentB) {
			if(parentA < parentB)
				parent[parentB] = parentA;
			else parent[parentA] = parentB;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n+1];
		for(int i = 0; i <= n; i++)
			parent[i] = i;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int boo = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(boo == 0) {
				if(find(a) != find(b))
					union(a, b);
			}
			else { // 1
				if(find(a) == find(b)) System.out.println("YES");
				else System.out.println("NO");
			}
		}

	}
}