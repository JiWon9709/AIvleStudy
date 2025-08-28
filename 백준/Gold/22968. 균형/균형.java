import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static long T, V;
    static long [] dp;

    // 모든 내부 정점에 대해 왼쪽, 오른쪽 부트리의 높이 차이가 1이하
    // 바텀 업 dp[i] = dp[i-1] + dp[i-2] + 1

    // V 범위 10억???
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Long.parseLong(br.readLine());
        StringBuilder sb = new StringBuilder();
        dp = new long[50];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        int idx = 3;
        while(idx < dp.length){
            dp[idx] = dp[idx-1] + dp[idx-2] + 1;
            idx++;
        }

        for (int t = 1; t <= T; t++){
            V = Long.parseLong(br.readLine());
            int depth = 0;
            while(depth+1 < idx && dp[depth+1] <= V) depth++;
            sb.append(depth).append('\n');
        }
        System.out.println(sb);
    }
}
