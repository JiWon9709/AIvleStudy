import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K, T, cnt, X, Y;
    static int[][] map;
    static Deque<int []> q;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static boolean[][] visited;

    public static void bfs(int i, int j) {
        q = new ArrayDeque<>();
        int new_x, new_y;
        q.add(new int[] {i, j});
        visited[i][j] = true;

        while(!q.isEmpty()) {
            int [] p = q.poll();
            int x = p[0];
            int y = p[1];

            for(int d = 0; d < 4; d++) {
                new_x = x + dx[d];
                new_y = y + dy[d];
                if (new_x >= 0 && new_x < N && new_y >= 0 && new_y < M) {
                    if(!visited[new_x][new_y] && map[new_x][new_y] == 1){
                        visited[new_x][new_y] = true;
                        q.add(new int[] {new_x, new_y});

                    }

                }
            }
        }
        cnt++;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            visited = new boolean[N][M];

            for(int i = 1; i <= K; i++) {
                st = new StringTokenizer(br.readLine());
                X = Integer.parseInt(st.nextToken());
                Y = Integer.parseInt(st.nextToken());
                map[Y][X] = 1;
            }

            cnt = 0;
            for(int i = 0; i < N; i++){
                for(int j = 0; j < M; j++){
                    if(!visited[i][j] && map[i][j] == 1)
                        bfs(i, j);
                }
            }
            System.out.println(cnt);
        }
    }
}