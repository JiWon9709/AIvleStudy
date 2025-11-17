import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, G, K;
    static mealkit[] list;
    public static class mealkit {
        private int s, l, o; // o가 1이면 뺄수 있음
        private boolean check; // 뺏는지 체크

        public mealkit(int s, int l, int o, boolean check) {
            super();
            this.s = s;
            this.l = l;
            this.o = o;
            this.check = check;
        }

    }

    public static boolean divide(long mid) {
        // 뺄수있는 균들 넣어서 내림차순
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        long total = 0;

        for(mealkit m : list) {
            long cur = m.s * Math.max(1, mid - m.l);
            total += cur;

            if(m.o == 1){
                pq.add(cur);
            }
        }

        int cnt = 0;
        while(K > cnt && !pq.isEmpty()){
            long p = pq.poll();
            total -= p;
            cnt++;
        }
        return total <= G ? true : false;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int s, l, o;
        int cnt = 0; // o가 1인 개수 = 뺄수 있는 재료개수
        list = new mealkit[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            o = Integer.parseInt(st.nextToken());
            cnt += (o == 1 ? 1 : 0);
            list[i] = new mealkit(s, l, o, false);
        }

        long left = 0;
        long right = 2000000000L;
        long x = 0;

        while(left <= right){
            long mid = (left + right) / 2;
            if(divide(mid)){
                x = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(x);
    }
}
