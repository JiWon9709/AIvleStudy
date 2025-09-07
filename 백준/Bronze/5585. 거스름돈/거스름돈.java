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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        M = Integer.parseInt(br.readLine());
        int g = 1000 - M;
        int[] coin = new int[] {500, 100, 50, 10, 5, 1};
        int idx = 0;
        while(g > 0 && idx < 6){
            if(g >= coin[idx]){
                g -= coin[idx];
                cnt++;
            }
            else idx++;
        }

        System.out.println(cnt);
    }
}