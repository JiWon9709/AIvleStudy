import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        // 122334669
        // arr[7] = 6
        // arr[3] = 2, arr[4] = 3
        // arr[1] = 1, arr[2] = 2
        long end = k;
        long start = 1;

        while(start < end){
            long mid = (start + end) / 2;
            long cnt = 0;

            for(int i = 1; i <= N; i++){
                cnt += Math.min(mid / i, N);
            }

            if(cnt < k) {
                start = mid + 1;
            }
            else end = mid;
        }

        System.out.println(start);
    }
}
