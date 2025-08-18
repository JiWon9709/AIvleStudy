import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	static int N;
	static int[] counting_sort;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		counting_sort = new int[10001];
		
		for(int i = 0; i < N; i++) {
			counting_sort[Integer.parseInt(br.readLine())]++; 
		}
		
//		Arrays.sort(arr); => sb 써야함
		for(int i = 1; i < counting_sort.length; i++) {
			while(counting_sort[i] > 0) {
				counting_sort[i]--;
				sb.append(i).append('\n');
			}
		}
		System.out.println(sb);
	}
}
