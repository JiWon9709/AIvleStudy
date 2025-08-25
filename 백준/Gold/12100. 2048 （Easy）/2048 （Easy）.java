//package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, max;
    static int[][] map;
    static int[] dx = {0, 1, -1, 0}; // 우 하 상 좌
    static int[] dy = {1, 0, 0, -1};

    /**
     * 5번 이동시켜서 얻을수 있는 가장 큰 블록
     * dfs(int depth)
     * 	if(depth == 5) return
     *  if(범위 내에 있다면 is_valid_map)
     * 		move(dir) = 상하좌우로 이동
     * 가장자리일 경우, 밀었던 방향의 전칸이 같은 숫자 인지 확인한후 add
     *
     * move(dir)
     * 	가장자리로 계속 이동 상하좌우로 ++
     * 	if 가장자리 전에 같은 숫자의 블록이 있는지... check()
     * 		add() 한번만 더할수 있음.
     *
     * check() 더할수 있는지 확인하는 함수.
     * add() = 같은 숫자면 + 해주는 함수
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
    // 0=오른쪽, 1=아래, 2=위, 3=왼쪽
    static int[][] move(int[][] board, int dir) {
        int[][] res = new int[N][N];

        if (dir == 0) { // RIGHT
            for (int r = 0; r < N; r++) {
                int write = N - 1;
                int last = 0;
                for (int c = N - 1; c >= 0; c--) {
                    int v = board[r][c];
                    if (v == 0) continue;
                    if (last == 0) {
                        last = v;
                    } else if (last == v) {
                        res[r][write--] = last * 2;
                        last = 0;
                    } else {
                        res[r][write--] = last;
                        last = v;
                    }
                }
                if (last != 0) res[r][write] = last;
            }
        } else if (dir == 1) { // DOWN
            for (int c = 0; c < N; c++) {
                int write = N - 1;
                int last = 0;
                for (int r = N - 1; r >= 0; r--) {
                    int v = board[r][c];
                    if (v == 0) continue;
                    if (last == 0) {
                        last = v;
                    } else if (last == v) {
                        res[write--][c] = last * 2;
                        last = 0;
                    } else {
                        res[write--][c] = last;
                        last = v;
                    }
                }
                if (last != 0) res[write][c] = last;
            }
        } else if (dir == 2) { // UP
            for (int c = 0; c < N; c++) {
                int write = 0;
                int last = 0;
                for (int r = 0; r < N; r++) {
                    int v = board[r][c];
                    if (v == 0) continue;
                    if (last == 0) {
                        last = v;
                    } else if (last == v) {
                        res[write++][c] = last * 2;
                        last = 0;
                    } else {
                        res[write++][c] = last;
                        last = v;
                    }
                }
                if (last != 0) res[write][c] = last;
            }
        } else { // LEFT
            for (int r = 0; r < N; r++) {
                int write = 0;
                int last = 0;
                for (int c = 0; c < N; c++) {
                    int v = board[r][c];
                    if (v == 0) continue;
                    if (last == 0) {
                        last = v;
                    } else if (last == v) {
                        res[r][write++] = last * 2;
                        last = 0;
                    } else {
                        res[r][write++] = last;
                        last = v;
                    }
                }
                if (last != 0) res[r][write] = last;
            }
        }
        return res;
    }

    /**
     *
     * @param board
     * @param dir
     * @return

    static int[][] move(int[][] board, int dir) {
        int[][] res = new int[N][N];

        if(dir == 0) { // 모든 좌표를 우방향으로 옮기기
            // 오른쪽 블록부터 계산
            for (int x = 0; x < N; x++) {
                for (int y = N - 1; y >= 0; y--) {
                    int val = board[x][y]; // 현재값 저장

                    while (y++ < N) {
                        if (is_valid_map(x,y) && board[x][y] > 0 || y == N) {
                            y--;
                            break;
                        }
                    }
                    // 한칸옆칸 좌표
                    int nx = x - dx[dir];
                    int ny = y - dy[dir];
                    // 다음 블록과 같은 값을 가진 경우
                    // 더하는 기회가 있고, 범위를 넘어가지 않고
                    if (is_valid_map(nx, ny) && (res[nx][ny] == 0 || board[nx][ny] == board[x][y]
                            || res[x][y] == board[nx][ny])) {
                        res[x][y] = board[x][y] * 2;
                    }
                    else res[x][y] = val;
                }
            }
        }
        // 하
        else if(dir == 1) {
            for (int y = 0; y < N; y++) {
                for (int x = N - 1; x >= 0; x--) {
                    int val = board[x][y]; // 현재값 저장

                    while (x++ < N) {
                        // 다른 블록을 만날때까지
                        if (is_valid_map(x,y) && board[x][y] > 0 || x == N) {
                            x--;
                            break;
                        }
                    }
                    // 한칸옆칸 좌표
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    // 다음 블록과 같은 값을 가진 경우
                    // 더하는 기회가 있고, 범위를 넘어가지 않고
                    if (is_valid_map(nx, ny) && res[nx][ny] == 0 && board[nx][ny] == board[x][y]) {
                        res[nx][ny] = board[x][y] * 2;
                    }
                    res[x][y] = val;
                }
            }
        }
        // 상
        else if(dir == 2) {
            for(int y = 0; y < N; y++) {
                for(int x = 0; x < N; x++) {
                    int val = board[x][y]; // 현재값 저장

                    while(x-- < N) {
                        // 다른 블록을 만날때까지
                        if(is_valid_map(x,y) && board[x][y] > 0) {
                            x++;
                            break;
                        }
                    }
                    // 한칸옆칸 좌표
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    // 다음 블록과 같은 값을 가진 경우
                    // 더하는 기회가 있고, 범위를 넘어가지 않고
                    if(is_valid_map(nx, ny) && res[nx][ny] == 0 && board[nx][ny] == board[x][y]) {
                        res[nx][ny] = board[x][y] * 2;
                    }
                    res[x][y] = val;
                }
            }
        }
        // 좌
        else {
            for(int x = 0; x < N; x++) {
                for(int y = 0; y < N; y++) {
                    int val = board[x][y]; // 현재값 저장

                    while (y-- < N) {
                        // 다른 블록을 만날때까지
                        if (is_valid_map(x, y) && board[x][y] > 0) {
                            y++;
                            break;
                        }
                    }
                    // 한칸옆칸 좌표
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    // 다음 블록과 같은 값을 가진 경우
                    // 더하는 기회가 있고, 범위를 넘어가지 않고
                    if (is_valid_map(nx, ny) && res[nx][ny] == 0 && board[nx][ny] == board[x][y]) {
                        res[nx][ny] = board[x][y] * 2;
                    }
                    res[x][y] = val;
                }
            }
        }
        return res;
    }
     */

    static void dfs(int[][] board, int depth) {
        if(depth == 5){
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(max, board[i][j]);
                }
            }
            return;
        }

        for(int d = 0; d < 4; d++) { // 4방향에 대해 이동할수 있는 경로 찾기
            int[][] next = move(board, d);
            dfs(next, depth+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(map, 0);
        System.out.println(max);
    }
}
