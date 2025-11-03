import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        char[] arr = br.readLine().trim().toCharArray();

        // cnt[k] = 해당 문자(T,G,F,P) 누적 개수의 mod 3 값
        int[] cnt = new int[4];

        // 상태 3^4 = 81 가지. freq[state] = 해당 상태가 지금까지 몇 번 나왔는지
        long[] freq = new long[81];
        // 시작 상태 (0,0,0,0)
        int state = 0;
        freq[state] = 1;

        long ans = 0;

        for (char c : arr) {
            int idx;
            switch (c) {
                case 'T': idx = 0; break;
                case 'G': idx = 1; break;
                case 'F': idx = 2; break;
                case 'P': idx = 3; break;
                default:  continue; // 문제에 없던 문자는 스킵(필요시 에러 처리)
            }

            // 누적 mod 3 갱신
            cnt[idx] = (cnt[idx] + 1) % 3;

            // 상태 인코딩: (((t)*3 + g)*3 + f)*3 + p
            state = (((cnt[0] * 3) + cnt[1]) * 3 + cnt[2]) * 3 + cnt[3];

            // 같은 상태가 이전에 k번 있었다면 그 k개와 현재를 짝지은 구간이 모두 유효
            ans += freq[state];
            freq[state]++;
        }

        System.out.println(ans);
    }
}
