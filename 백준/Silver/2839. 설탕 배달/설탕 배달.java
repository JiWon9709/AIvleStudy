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
        N = Integer.parseInt(br.readLine());

        while(N > 0){
            if(N % 5 == 0){
                N -= 5;
                cnt++;
            }
            else if(N >= 5 && N % 3 != 0){
                N -= 5;
                cnt++;
            }
            else if(N >= 3){
                N -= 3;
                cnt++;
            }
            else break;
        }
        if(N > 0) System.out.println(-1);
        else System.out.println(cnt);
    }
}