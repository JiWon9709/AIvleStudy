import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int max = 0;
		double sum = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< N; i++) {
			int score = Integer.parseInt(st.nextToken());
			arr[i] = score;
			max = Math.max(max, arr[i]);
		}
		
		for(int i = 0; i < N; i++) {
			double new_score = (double)arr[i] / (double)max * 100;
			sum += new_score;
		}
		System.out.println(sum / N);
	}
}
