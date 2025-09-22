import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        // 2, 3 => 1*2, 1+2
        // 4, 4 => 2*2, 2+2
        // 5, 6 => 2*3, 2+3
        // 14, 9 => 1+1+1+1+/1+1+1+/1+1
        // 11, 48 => 10C1 ,10C2
        // a1 + a2 + a3
        // 조합? 막대기를 하나씩 추가해보기?
        // 약수 구해서 약수중 여러개 더해서 되는지??
        // a -> a' -> a''
        // 5, 7 =>  1 * 5 * 1 / 1+1+5
        // 5, 8 => 1 * 1 * 1 * 5 = >8
        for(int t = 0; t < T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println("yes");
        }
    }
}