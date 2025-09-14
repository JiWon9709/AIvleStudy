import java.awt.Point;
import java.io.*;
import java.util.*;

/**
 * i -> j 경로 있는지 체크
 *
 */
public class Main {
    static int min, max, N;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N];
        for(int i = 0; i < N; i++){
            list[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                int d = Integer.parseInt(st.nextToken());
                if(d == 1)
                    list[i].add(j);
            }
        }

        int [][]graph = new int[N][N];
        for(int i = 0;i <N; i++){
            for(int j = 0; j <N; j++){
                if(check_dist(i, j)) graph[i][j] = 1;
                else graph[i][j] = 0;
            }
        }

        for(int i = 0; i< N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }

    }
}