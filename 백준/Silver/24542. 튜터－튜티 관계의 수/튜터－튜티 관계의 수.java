import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	/**
	 * 튜터가 튜티에게만 전달할수 있도록함
	 * tutee 0 1 2 3 4 5
	 * 		 0 1 1 4 2 ..
	 * 
	 * 최소 튜터의 수가 아니라 모든 경우의 수이다!
	 * 
	 * 배열은 자기자신으로 초기화
	 * arraylist에 정보를 저장해서 가장 많은 자식을 가지고 있는 부모를 튜터로 선정
	 * 배열에 튜터 저장, 자기자신은 그대로
	 * 자식의 다른 노드가 있는 경우? 
	 *
	 * union, find
	 *
	 */
	static int N, M;
	static int[] tutee;
	static long A = 1000000007;
	
	public static void union(int a, int b) {
		int parentA = find(a);
		int parentB = find(b);
		
		// 작은 원소를 부모로하기
		if(parentA < parentB) {
			tutee[parentB] = parentA;
		}
		else tutee[parentA] = parentB;
	}
	
	public static int find(int x) {
		if(x == tutee[x]) return x;
		else
			return find(tutee[x]);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tutee = new int[N+1];
		
		for(int i = 1; i < N+1; i++) {
			tutee[i] = i; // 대표노드를 자기자신으로 초기화
		 }
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			union(u, v);
		}
//		System.out.println(Arrays.toString(tutee));
		
		int[] count = new int[N+1];
		for(int i = 1; i <= N; i++) {
			count[find(tutee[i])]++;
		}
		
		long cnt = 1;
		for(int i = 1; i <= N; i++) {
			if(count[i] >= 1) {
				cnt = (cnt * count[i]) % A;
			}
		}
		
		System.out.println(cnt);
	}
}
