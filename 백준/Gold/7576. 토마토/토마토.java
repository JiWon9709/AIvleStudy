import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, cnt;
    static int[][] map;
    static Deque<int []> q;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};

    public static void bfs() {
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int x = pos[0];
            int y = pos[1];

            for(int i = 0; i < 4; i++){
                if(x+dx[i] >= 0 && x+dx[i] < N && y+dy[i] >=0 && y+dy[i] < M){
                    if(map[x+dx[i]][y+dy[i]] == 0){
                        map[x+dx[i]][y+dy[i]] = map[x][y] + 1;
                        q.add(new int[] {x+dx[i], y+dy[i]});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        q = new ArrayDeque<>();

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) q.add(new int[] {i, j});
            }
        }

        cnt = 0;
        bfs();
        boolean minus = false;

        for(int i = 0; i < N; i++){
            for(int j= 0; j < M; j++){
                if(map[i][j] == 0){
                    minus = true;
                    break;
                }
                cnt = Math.max(cnt, map[i][j]);
            }
        }

        if(minus) System.out.println(-1);
        else System.out.println(cnt-1);
    }
}