import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] parent;
	
	static int find(int x) {
		if(parent[x] == x) return x;
		return find(parent[x]);
	}
	
	static void union(int x, int y) {
		int pa = find(x);
		int pb = find(y);
		
		if(pa != pb) {
			if(pa < pb)
				parent[pb] = pa;
			else
				parent[pa] = pb;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int know_truth_num = Integer.parseInt(st.nextToken());
		ArrayList<Integer> know_truth_list = new ArrayList<>(); // 진실을 아는 사람들
		for(int i = 0; i < know_truth_num; i++) {
			know_truth_list.add(Integer.parseInt(st.nextToken()));
		}
		
		
		ArrayList<Integer>[] party = new ArrayList[M]; // 파티에 참석한 사람들
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			party[i] = new ArrayList<>();
			int party_num = Integer.parseInt(st.nextToken());
			for(int j = 0; j < party_num; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		parent = new int[N+1];
		for(int i = 1; i < N+1; i++) {
			parent[i] = i;
		}
		
		// 파티에 참석한 사람들중 진실을 아는 사람들 추가하기
		// 같은 파티에 참석한 사람들끼리 집합으로 만들기
		for(int i = 0; i < M; i++) {
			int first = party[i].get(0);
			for(int p : party[i]) {
				if(p == first) continue;
				union(p, first);
			}
		}
		
		// 진실을 아는 사람들 하나의 집합으로 만들기
		// union 할 원소를 맨 앞 원소로 설정
		int first = -1;
		for(int t : know_truth_list) {
			if(first == -1) {
				first = t;
				continue;
			}
			union(first, t);
		}
		
		// 파티에 참석한 사람들중 거짓말을 할수 있는 파티수 세기
		int cnt = 0;
		if(know_truth_num == 0) cnt = M;
		else {
			int know_truth_first = know_truth_list.get(0);
			for(int i = 0; i < M; i++) {
				boolean canlie = true;
				for(int p: party[i]) {
					if(find(p) == find(know_truth_first)) {
						canlie = false;
						break;
					}
				}
				if(canlie) cnt++;
			}
		}
		System.out.println(cnt);
	}
}
