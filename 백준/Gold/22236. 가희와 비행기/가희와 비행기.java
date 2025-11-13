import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

// 중간에 0이 되면 안됨
// 상승을 +1, 하강을 -1
// d의 범위가 4000까지이므로 d/2개수씩 +1, -1
public class Main {
    static int d, m, min;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        long[][] dp = new long[4001][4001];
        dp[1][1] = 1;

        // i : 이동한 거리 / j : 현재 높이
        // 첫 이동이 반드시 +1 ~ 마지막이동은 반드시 -1이므로
        // d의 범위가 2~d-1까지
        for(int i = 2; i < d; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i][j] = (dp[i-1][j+1] + dp[i-1][j-1]) % m;
            }
        }

        System.out.println(dp[d-1][1] % m);
    }
}
