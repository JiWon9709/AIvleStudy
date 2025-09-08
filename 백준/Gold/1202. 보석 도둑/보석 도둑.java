import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static class jewel implements Comparable<jewel>{
		int weight, price;

		public jewel(int weight, int price) {
			super();
			this.weight = weight;
			this.price = price;
		}

		@Override
		public int compareTo(jewel o) {
			// TODO Auto-generated method stub
//			if(this.weight == o.weight)
//				return o.price - this.price;
			return this.weight - o.weight;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		jewel[] jewels = new jewel[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			jewels[i] = new jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		int[] bags = new int[K];
		for(int i = 0; i < K; i++) {
			bags[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(bags);
		Arrays.sort(jewels);
		
		PriorityQueue<jewel> jewel_pq = new PriorityQueue<>((a, b) -> b.price - a.price);
		int idx = 0;
		long w = 0;
		
		for(int i =0; i < K; i++) {
			while(idx < N) {
				if(bags[i] >= jewels[idx].weight) {
					jewel_pq.add(jewels[idx++]);
				}
				else break;
			}
			if(!jewel_pq.isEmpty())
				w += jewel_pq.poll().price;
		}
		
		System.out.println(w);
	}
}