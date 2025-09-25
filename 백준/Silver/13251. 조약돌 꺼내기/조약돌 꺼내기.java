import java.io.*;
import java.util.*;

public class Main {
    static int m, k, n;
    static int[][] dp;
    static int[] color;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        m = Integer.parseInt(br.readLine());
        color = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
        	color[i] = Integer.parseInt(st.nextToken());
        	n += color[i]; // 전체 개수
        }
        	
        k = Integer.parseInt(br.readLine());
        
//        dp = new int[n+1][n+1];
//        
//        dp[1][0] = 1;
//        dp[1][1] = 1;
//        for(int i = 2; i <= n; i++) {
//        	dp[i][0] = 1;
//        	for(int j = 1; j <= n; j++) {
//        		dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
//        	}
//        }
        double num = 0; // 분자
        double result = 1;
        for(int i = 0; i < m; i ++) {
        	result = 1;
        	for(int K = 0; K < k; K++) {
        		result *= (double)(color[i] - K) / (double)(n - K);
        	}
        	num += result;
//        	num += (double)dp[color[i]][k] / (double)dp[n][k];
        }
        
        System.out.println(num);
    }
}