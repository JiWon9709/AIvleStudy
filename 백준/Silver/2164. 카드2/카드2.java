import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	static int N;
	static int cnt;
	static int[] numbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Queue<Integer> q = new ArrayDeque<>();
		
		// 큐에 1~N까지 넣기
		for(int i = 1; i <=N; i++) {
			q.add(i);
		}
		
		int tmp;
		while(q.size() > 1) {
		// 1. 제일 위에 있는 카드를 버림
			q.poll();
		// 2. 맨뒤로 옮김
			q.add(q.poll());
		}
		// 제일 뒤에 남는 카드
		System.out.println(q.peek());
	}
}