import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
    static int N, cnt;
    static Long[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new Long[N];
        cnt = 0;

        // -10억 ~ 10억
        for(int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr);


        for(int i = 0; i < N; i++){
            Long num = arr[i];
            int left = 0;
            int right = N-1;

            while(left < right){
                if(left == i) {
                    left++;
                    continue;
                }
                if(right == i){
                    right--;
                    continue;
                }

                if(arr[left]+ arr[right] == num) {
                    cnt++;
                    break;
                }
                else if(arr[left]+ arr[right] < num){
                    left++;
                }
                else if(arr[left]+ arr[right] > num){
                    right--;
                }
            }
        }
        System.out.println(cnt);
    }
}
