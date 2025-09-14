import java.awt.Point;
import java.io.*;
import java.util.*;

/**
 *
 */
public class Main {
    static int min, max, N, M;
    static int[] arr;
    static ArrayList<Integer>[] list;
    static boolean check_dist(int i, int j){
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(i);
        visited[i] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int next: list[cur]){
                if(next == j) return true;
                if(!visited[next]){
                    q.offer(next);
                    visited[next] = true;
                }
            }
        }
        return false;
    }

    static class Node implements Comparable<Node>{
        int idx, dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            if(this.dist == o.dist) return this.idx - o.idx;
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        int[][] table = new int[N+1][N+1];
        for(int i = 1; i <=N ;i++){
            Arrays.fill(table[i], Integer.MAX_VALUE);
            table[i][i] = 0;
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
            table[a][b] = 1;
            table[b][a] = 1;
        }

        // 플로이드 워샬
        int[] min_dist = new int[N+1];
        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j<= N; j++){
                    if (table[i][k] != Integer.MAX_VALUE && table[k][j] != Integer.MAX_VALUE) {
                        if (table[i][j] > table[i][k] + table[k][j])
                            table[i][j] = table[i][k] + table[k][j];
                    }
                }
            }
        }

        for(int i = 1; i <= N; i++){
//            System.out.println(Arrays.toString(table[i]));
            for(int j = 1; j <=N; j++){
                min_dist[i] += table[i][j];
            }
        }

//        System.out.println(Arrays.toString(min_dist));

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int i = 1; i <= N; i++){
            pq.add(new Node(i, min_dist[i]));
        }
        System.out.println(pq.peek().idx);
    }
}