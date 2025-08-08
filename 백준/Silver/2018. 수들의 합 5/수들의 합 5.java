import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int i = 1;
		int j = 1;
		int sum = 1;
		int count = 1;
		
		while(i != N) {
			if(sum < N) {
				j++;
				sum += j;
			}
			else if(sum > N) {
				sum -= i;
				i++;
			}
			else if(sum == N) {
				j++;
				count++;
				sum += j;
			}
		}
		System.out.println(count);
	}
}