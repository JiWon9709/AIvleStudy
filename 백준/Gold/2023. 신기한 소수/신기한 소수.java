import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	/**
	 * 왼쪽부터 1자리, 2자리, 3자리, 4자리 모두 소수
	 * N자리의 숫자중에서 어떤수들이 소수인가?
	 * 한줄씩 출력
	 * 
	 * 소수 => 2, 3, 5, 7
	 * 11, 13, 17, 19, 23, ,,,
	 * 
	 * dfs
	 * 한자리수일 경우: 자기자신 이외의 수와 나누어 떨어질 경우
	 * 
	 * 
	 */
	
	static int N;
	static ArrayList<ArrayList<Integer>> prime_number = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();
	public static boolean cal_prime_number(int n) {
		for(int i = 2; i < n; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void find_prime_number(int n, int j) {
		if(j == N) { // 자리수가 같으면
			if(cal_prime_number(n))
				sb.append(n).append('\n');
			return ;
		}
		
		for(int i = 1; i <= 9; i++) {
			if(i % 2 == 0) // 짝수일 경우 건뛰
				continue;
			// 자리수를 추가해서 계산했을때 소수일 경우 재귀
			if(cal_prime_number(n * 10 + i)) find_prime_number(n * 10 + i, j+1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		// 1의 자리의 소수는 2, 3, 5, 7이므로 왼쪽부터 1자리수만큼 소수여야하기 때문에
		find_prime_number(2, 1);
		find_prime_number(3, 1);
		find_prime_number(5, 1);
		find_prime_number(7, 1);
		
		System.out.println(sb);
	}
}