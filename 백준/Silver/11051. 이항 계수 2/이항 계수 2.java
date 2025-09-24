import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 10007;
    static int n, r;
    static int[][] dp; // dp[i][j] = iCj

    static void buildPascal() {
        dp = new int[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1; // iC0 = 1
            dp[i][i] = 1; // iCi = 1
            for (int j = 1; j < i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        buildPascal();
        System.out.println(dp[n][r]);
    }
}
