import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, K;

    /**
     * 버블 소트 중 swap이 멈추는 때의 인덱스를 구하기
     * 인덱스는 1부터임!
     * 입력 - 시간제한 2초 - 50만 - n^2 : 시간초과
     * nlogn
     *
     * 한번 정렬할때 왼쪽으로 1칸씩만 움직이기 가능
     * but 오른쪽은 무제한으로 움직일수있음
     *
     * @param args
     * @throws Exception
     */
    private static class Node implements Comparable<Node>{
        int num, idx;

        public Node(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node o) {
            return num - o.num;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
//        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(br.readLine());

        Node [] arr = new Node[N+1]; // (0) 10 1 5 2 3

        for(int i = 1; i <= N; i++){
            arr[i] = new Node(Integer.parseInt(br.readLine()), i);
        }
        Arrays.sort(arr, 1, N+1);
        int max = 0;
        for(int i = 1; i <= N; i++){
            max = Math.max(max, arr[i].idx - i);
        }
        System.out.println(max+1);
    }
}