import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
    static int combination(int a, int b){
        int result = 1;
        int cnt = b;
        while(cnt > 0){
            result = result * a;
            cnt--;
            a--;
        }
        while(b > 0){
            result /= b;
            b--;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        System.out.println(combination(a, b));
    }
}