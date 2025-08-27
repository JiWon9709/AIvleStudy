//package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, max;
    static int[] arr;
    static int[] dx = {0, 1, -1, 0}; // 우 하 상 좌
    static int[] dy = {1, 0, 0, -1};

    /**
     *
     *
     *
     * @param args
     * @throws IOException
     */

    static boolean is_valid_map(int x, int y) {
        if(x >= 0 && x < N && y >= 0 && y < N)
            return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        int start = 0;
        int end = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            end += arr[i];
            start = Math.max(start,arr[i]);
        }

        // (45 + 9) / 2 = 27 = mid
        // start = 9, end = 45
        while(start <= end){
            int mid = (start + end) / 2;
            int cnt = 1;
            int sum = 0;

            for(int i = 0; i < N; i++){
                sum += arr[i];
                if(sum > mid) {
                    sum = arr[i];
                    cnt++;
                }
            }

            if(cnt > M) {
                start = mid + 1;
            }
            else end = mid - 1;
        }

        System.out.println(start);
    }
}
