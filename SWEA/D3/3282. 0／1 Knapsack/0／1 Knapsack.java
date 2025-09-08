import java.awt.Point;
import java.io.*;
import java.util.*;


public class Solution {
	static class bag implements Comparable<bag>{
		int v, c;

		public bag(int v, int c) {
			super();
			this.v = v;
			this.c = c;
		}

		@Override
		public int compareTo(bag o) {
			// TODO Auto-generated method stub\
			if(this.v == o.v) return this.c - o.c;
			return this.v - o.v;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T ;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			bag[] things = new bag[N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				things[i] = new bag(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(things);
			
			int []dp = new int[K+1];
			for(int i = 0; i < N; i++) {
				for(int j = K; j >= things[i].v; j--) {
					dp[j] = Math.max(dp[j], dp[j - things[i].v] + things[i].c);
				}
			}
			
			System.out.println("#" + t + " " + dp[K]);
		}
		
	}
}