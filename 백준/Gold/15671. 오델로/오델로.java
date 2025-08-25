//package algo;

import java.io.*;
import java.util.*;

public class Main {
    static final int SIZE = 6;
    static final int BLACK = -1;
    static final int WHITE = 1;

    static int[][] board = new int[SIZE][SIZE];
    static int[] dr = {-1,-1, 0, 1, 1, 1, 0,-1};
    static int[] dc = { 0, 1, 1, 1, 0,-1,-1,-1};

    static boolean in(int r, int c) {
        return 0 <= r && r < SIZE && 0 <= c && c < SIZE;
    }

    // 해당 색(color)이 (r,c)에 둘 수 있는가?
    static boolean isValidMove(int[][] b, int r, int c, int color) {
        if (!in(r,c) || b[r][c] != 0) return false;
        int opp = -color;

        for (int d = 0; d < 8; d++) {
            int r2 = r + dr[d], c2 = c + dc[d];
            int cnt = 0;

            // 첫 칸부터 연속한 상대 돌을 최소 1개 이상 지나야 함
            while (in(r2, c2) && b[r2][c2] == opp) {
                r2 += dr[d];
                c2 += dc[d];
                cnt++;
            }
            // 상대 돌을 하나 이상 지나고, 그 다음이 내 돌이면 유효
            if (cnt > 0 && in(r2, c2) && b[r2][c2] == color) return true;
        }
        return false;
    }

    // (r,c)에 color가 둔다. 가능하면 뒤집고 true, 아니면 false
    static boolean applyMove(int[][] b, int r, int c, int color) {
        if (!isValidMove(b, r, c, color)) return false;

        int opp = -color;
        b[r][c] = color;

        for (int d = 0; d < 8; d++) {
            int r2 = r + dr[d], c2 = c + dc[d];
            int cnt = 0;

            while (in(r2, c2) && b[r2][c2] == opp) {
                r2 += dr[d];
                c2 += dc[d];
                cnt++;
            }
            if (cnt > 0 && in(r2, c2) && b[r2][c2] == color) {
                // 사이에 있던 상대 돌들을 모두 뒤집기
                int rr = r + dr[d], cc = c + dc[d];
                for (int k = 0; k < cnt; k++) {
                    b[rr][cc] = color;
                    rr += dr[d]; cc += dc[d];
                }
            }
        }
        return true;
    }

    static boolean hasAnyValidMove(int[][] b, int color) {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (isValidMove(b, i, j, color)) return true;
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim()); // 수의 개수

        // 초기 배치(0-index)
        for (int[] row : board) Arrays.fill(row, 0);
        board[2][2] = WHITE; board[3][3] = WHITE;
        board[2][3] = BLACK; board[3][2] = BLACK;

        boolean blackTurn = true; // 흑(BLACK)부터
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;

            int color = blackTurn ? BLACK : WHITE;

            // 현재 색이 둘 곳이 없으면 패스
            if (!hasAnyValidMove(board, color)) {
                blackTurn = !blackTurn;
                color = blackTurn ? BLACK : WHITE;

                // 상대도 둘 곳이 없으면 조기 종료
                if (!hasAnyValidMove(board, color)) break;
            }

            // 입력 좌표가 현재 색으로 유효하면 둔다. 아니면 (문제 형식에 따라) 무시하거나 종료.
            if (applyMove(board, r, c, color)) {
                blackTurn = !blackTurn; // 성공적으로 뒀으면 턴 교대
            } else {
                // 유효치 않은 입력이면: 여기서는 그냥 무시하고 턴 유지/혹은 교대 등 규칙에 맞게 처리
                // 필요시 아래 주석 해제
                // blackTurn = !blackTurn;
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        int b = 0, w = 0;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == 0) sb.append('.');
                else if (board[i][j] == BLACK) { sb.append('B'); b++; }
                else { sb.append('W'); w++; }
            }
            sb.append('\n');
        }
        if (b > w) sb.append("Black");
        else if (w > b) sb.append("White");
        else sb.append("Draw");
        System.out.println(sb);
    }
}
