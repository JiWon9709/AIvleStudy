import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static int N, count;
    static int []arr;
    static boolean is_valid(int col) {
        for(int i = 0; i < col; i++){
            if(arr[col] == arr[i]) {
                return false;
            }
            else if(Math.abs(col - i) == Math.abs(arr[col] - arr[i])){
                return false;
            }
        }
        return true;
    }
    static void dfs(int cnt){
        if(cnt == N){
            count++;
            return ;
        }

        for(int i = 0; i < N; i++){
            arr[cnt] = i;
            if(is_valid(cnt)) {
                dfs(cnt + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dfs(0);
        System.out.println(count);
    }
}
