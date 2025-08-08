import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	static int N;
	static int[] numbers;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		numbers = new int[N];
		for(int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);
		
		int cnt = 0;
		int sum = 0;
		// 1 2 3 4 5 7
		// i j
		for(int i = 0; i < N; i++) {
			if(numbers[i] > M) break;
			for(int j = i+1; j < N; j++) {
				sum = numbers[i] + numbers[j];
				if(sum == M) {
					cnt++;
					break;
				}
				else if(sum > M) {
					break;
				}
			}
		}
		System.out.println(cnt);
	}
}