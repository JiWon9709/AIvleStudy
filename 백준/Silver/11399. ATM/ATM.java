import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	/**
	 * N명의 사람들 1~N번
	 * i번 사람이 돈을 인출하는데 걸리는 시간 Pi분
	 * 
	 * 최소 = Pi 오름차순 + 누적합
	 * o(n^2) 가능 할거같은데...?
	 * Arrays.sort = O(nlogn)
	 * @param args
	 */
	static int N;
	static int[] arr;
	static int[] arr_sum;
	
//	public static void bubble_sort() {
//		for(int i = 0; i < N-1; i++) {
//			for(int j = 1; j <)
//		}
//	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		arr_sum = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
//		bubble_sort();
//		merge_sort();
		Arrays.sort(arr);
		int sum = 0;
		for(int i = 0; i < N; i++) {
			sum += arr[i];
			arr_sum[i] = sum;
		}
		sum = 0;
		for(int n : arr_sum) {
			sum += n;
		}
		System.out.println(sum);
	}
}