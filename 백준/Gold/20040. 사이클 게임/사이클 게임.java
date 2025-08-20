import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	/**
	 * 사이클이 완성되는 순간 게임 종료
	 * 입력 받으면서 union 합연산
	 * 입력 받을때마다 사이클 있는지 체크
	 * 있으면 해당 차례의 인덱스 출력
	 * 
	 * 입력: n, m
	 * 출력: 사이클이 처음으로 만들어진 차례의 번호
	 * m번을 모두 처리한 이후에도 종료되지 않으면 0 출력
	 *
	 */
	static int n, m;
	static int[] parent;	
	
	public static void union(int x, int y) {
		int parentX = find(x);
		int parentY = find(y);
		
		if(parentX < parentY) parent[parentY] = parentX;
		else parent[parentX] = parentY;
	}
	
	public static int find(int x) {
		if(x == parent[x]) // 자기자신이 대표일 경우
			return x;
		return find(parent[x]);
	}
	
	public static boolean check_cycle(int x, int y) {
		if(find(x) == find(y)) return true;
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		parent = new int[n];
		for(int i = 0; i < n; i++) {
			parent[i] = i;
		}
		
		int idx = 0;
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			if(check_cycle(u, v)) {
				idx = i;
				break;
			}
			
			union(u, v);
		}
		System.out.println(idx);
	}
}