import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        for (int a = 0; a <= n; a++) {
            int b = n - a;
            if (a * b < k) continue; // 최대 쌍 < k이면 불가능

            // 기본 문자열: A...AB...B
            char[] result = new char[n];
            for (int i = 0; i < a; i++) result[i] = 'A';
            for (int i = a; i < n; i++) result[i] = 'B';

            int remain = a * b - k; // 줄여야 하는 쌍 개수
            // 오른쪽 A부터 하나씩 뒤로 밀기
            for (int i = a - 1; i >= 0 && remain > 0; i--) {
                int can_move = Math.min(remain, b); // 이 A가 움직일 수 있는 최대 거리
                // 뒤로 can_move 칸 밀기
                char temp = result[i];
                for (int j = i; j < i + can_move; j++) {
                    result[j] = result[j + 1]; // 오른쪽으로 한 칸씩 당김
                }
                result[i + can_move] = temp;
                remain -= can_move;
                b--; // B 하나 자리를 왼쪽으로 뺏김
            }

            System.out.println(new String(result));
            return;
        }
        System.out.println(-1);
    }
}
