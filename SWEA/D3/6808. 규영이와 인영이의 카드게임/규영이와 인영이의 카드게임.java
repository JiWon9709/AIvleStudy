//package Daily;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int N=9;
	static int[] numbers = new int[N];
	static int[] gyuCard = new int[N];
	static int[] inCard = new int[N];
	static boolean[] isSelected = new boolean[N];
	static boolean[] isCard = new boolean[19];
	static int winCount = 0;
	static int loseCount = 0;
	
	public static void permutation(int cnt) {
		if(cnt == N) { // 순열로 배열 하나 완성 했을때
			int gsum = 0;
			int isum = 0;
			for(int i = 0; i < N; i++) {
				if(numbers[i] < gyuCard[i]) gsum += numbers[i] + gyuCard[i];
				else if(numbers[i] > gyuCard[i]) isum += numbers[i] + gyuCard[i];
				else continue;
			}
			if(gsum > isum) winCount++;
			else if(gsum < isum) loseCount++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			isSelected[i] = true;
			numbers[cnt] = inCard[i];
			permutation(cnt+1);
			isSelected[i] = false;
		}
		
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			Arrays.fill(isCard, false);
			
			for(int i = 0; i < N; i++) {
				gyuCard[i] = Integer.parseInt(st.nextToken());
				isCard[gyuCard[i]] = true;
			}
			
			int idx = 0;
			for(int i = 1; i <= 18; i++) {
				if(isCard[i]) continue;
				inCard[idx++] = i;
			}
			
			winCount = 0;
			loseCount = 0;
			permutation(0);
            System.out.println("#" + test_case+" " + winCount + " " + loseCount);
		}
	}
}