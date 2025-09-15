import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static Card[] list;
	static int N;
	
	static class Card{
		String title;

		public Card(String title) {
			super();
			this.title = title;
		}

		@Override
		public String toString() {
			return "Card [title=" + title + "]";
		}
		
		
	}
	
	static void shuffle(int left, int right) {
//		int mid;
		int mid = (left + right) / 2;
//		if(N % 2 == 0) 
//			mid = (left + right) / 2;
//		else mid = (left + right) / 2 + 1;
		Card[] copylist = new Card[N+1];
		
		int start_l = left;
		int start_r = mid;
		if(N % 2 != 0)
			start_r = mid+1;
		
		
		for(int idx = 0; idx < N; idx++) {
			if(idx % 2 == 0)
				copylist[idx] = new Card(list[start_l++].title);
			else copylist[idx] = new Card(list[start_r++].title);
		}
		
		if(N % 2 == 1 && start_l == mid) copylist[N-1] = list[start_l];
		
		for(int i = 0; i < N; i++) {
			list[i] = copylist[i];
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer sb = new StringBuffer();
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			list = new Card[N];
			
			int i = 0;
			while(st.hasMoreTokens()) {
				list[i++] = new Card(st.nextToken());
			}
			
			shuffle(0, N);
			
			sb.append("#" + t + " ");
			for(Card c: list) {
				sb.append(c.title).append(" ");
			}
			sb.append("\n");
			
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();

	}

}
