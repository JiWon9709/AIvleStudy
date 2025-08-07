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
	static int N=100;
	static int[][] map = new int[100][100];
	static int start = 0;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1; test_case <= 10; test_case++)
		{
            int T = Integer.parseInt(br.readLine());
			for(int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 2) start = j;
				}
			}
			
			int x = 99;
			while(x > 0) {
				if(start > 0 && map[x][start-1] == 1) {
					while(start > 0 && map[x][start-1] == 1) start--;
				}
				else if(start < 99 && map[x][start+1] == 1) {
					while(start < 99 && map[x][start+1] == 1) start++;
				}
				x--;
			}
			
            System.out.println("#" + test_case+" " + start);
		}
	}
}