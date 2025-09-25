import java.io.*;
import java.util.*;

public class Main {
    static int r, n, result;
    static int[][] dp;
    static void combination(int cnt, int pick){
        if(cnt == n) {
            if(pick == r) result++;
            return ;
        }


        combination(cnt+1, pick+1);
        combination(cnt+1, pick);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());

            result = 0;
            dp = new int[n+1][r+1];
            
            dp[1][0] = 1;
            dp[1][1] = 1;
            for(int i = 2; i <= n; i++) {
            	dp[i][0] = 1;
            	for(int j = 1; j <= r; j++) {
            		dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            	}
        
            }
//            combination(0, 0);
            System.out.println(dp[n][r]);
        }

    }
}