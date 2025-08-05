
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

// 1. 배열 -> 시간초과 : O(MN)
// 2. ArrayList -> 시간초과
// 3. 누적합으로 구하기
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N+1];
		int i = 0;
		arr[0] = 0;
		while(st.hasMoreTokens()) {
			arr[i+1] = arr[i]+ Integer.parseInt(st.nextToken());
			i++;
		}
	
		for(int cnt = 0; cnt < M; cnt++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int sum = 0;
//			for(int range = start-1; range < end; range++) {
//				sum += arr[range];
//			}
			if(start > 1)
				System.out.println(arr[end] - arr[start-1]);
			else System.out.println(arr[end]);
		}
	}
}
