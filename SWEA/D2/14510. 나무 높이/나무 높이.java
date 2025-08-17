import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {
    /**
     * N개의 나무.
     * 하루에 한 나무에 물을 줄 수 있음.
     * 홀수 날 - 1 / 짝수 - 2
     * 모든 나무의 키가 처음에 가장 컸던 나무와 같아지도록 하는 최소 날짜수
     * 물을 주지 않은 날도 있을 수 있음.
     *
     * 4 2
     * 완탐 - 1일째  0 - 안주기 : 4 2
     *            1 - 홀수 날 이므로 +1 : 4 3
     *      2일째  0 - 안주기 : 4 3
     *            2 - 짝수 날 이므로 +2 : 4 4
     * 백트래킹, 큐에 나무 idx 저장
     * days = 홀수 날 일때,
     * 큐에서 뺀 나무의 높이가 최대 높이와의 차이가 2로 나누었을때 1이 남을 경우,
     * 높이 +1 해서 최대 높이와 같지 않을 경우 큐에 다시 넣기
     *
     * 짝수 날일때, 최대 높이와의 차이가 2로 나누었을때 0 일 경우,
     * 높이 +2
     *
     * 모든 나무의 높이가 최대 값과 같아야함
     * 배열 값 하나씩 비교하면서 성공하면 tree
     * -----
     * 그리디
     * @param args
     */
    private static int N, maxh;
    private static int days;
    private static int[] trees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            trees = new int[N];
            maxh = Integer.MIN_VALUE;

            for(int i = 0; i< N; i++){
                trees[i] = Integer.parseInt(st.nextToken());
                if(maxh < trees[i]){
                    maxh = trees[i];
                }
            }

            days = 0;
            // 2 3 10 5
            // 8 7 0 5
            //
            // 2+2+2+2
            // 2+2+2+1
            // 2+2+1
            int oddcnt = 0;
            int evencnt = 0;

            for(int i = 0; i < N; i++){
                int diff = maxh - trees[i];
                if(diff <= 0) continue;
                evencnt += diff / 2;
                oddcnt += diff % 2;
            }

            while(evencnt - oddcnt > 1){
                evencnt--;
                oddcnt += 2;
            }

            if(evencnt >= oddcnt) days = evencnt * 2;
            else days = oddcnt * 2 - 1;

            System.out.println("#"+test_case+" "+days);
        }
    }
}
