import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 페르마의 소정리
// a^p === a (%p)
// a^p-2 === a^-1 (%p)
public class Main {
    static long[] fact;
    static long mod = 1234567891;
    static int n, res, x, y;
    static boolean[][] map;

    static boolean is_check() {
        for(int i = 0; i < x-1; i++){
            for(int j = 0; j < y-1; j++){
                if(map[i][j] && map[i][j+1] && map[i+1][j] && map[i+1][j+1]) return false;
            }
        }
        return true;
    }
    static void dfs(int num){
        int row = num / y;
        int col = num % y;
        if(num == x * y) {
            if(is_check()) res++;
            return;
        }

        map[row][col] = true;
        dfs(num+1);

        map[row][col] = false;
        dfs(num+1);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        map = new boolean[x][y];

        n = x * y;
        dfs(0);
        System.out.println(res);

    }

}
