import java.awt.Point;
import java.io.*;
import java.util.*;

/**
 * 최대 최소 구하기
 *
 *
 * 1. 모든 조합 구해보기(dfs) + - * /
 * 2. arraylist에 넣고 * 나 / 있으면 빼서 계산해서 넣기
 * 3. 앞에서부터 계산
 *
 */
public class Main {
    static int min, max, N;
//    static int[] oper_arr; // 0+ 1- 2* 3/
    static int[] arr;
    static int cal_all(int oper_arr[]){
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Integer> opers = new ArrayList<>();
        nums.add(arr[0]);

        for(int i = 0; i < N-1; i++){
            int oper = oper_arr[i];
            if(oper == 2){
                int prev = nums.remove(nums.size() - 1);
                nums.add(prev * arr[i+1]);
            }
            else if(oper == 3){
                int prev = nums.remove(nums.size() - 1);
                nums.add(prev / arr[i+1]);
            }
            else {
                nums.add(arr[i+1]);
                opers.add(oper);
            }
        }

        int total = nums.get(0);
        for(int i = 0; i < opers.size(); i++){
            if(opers.get(i) == 0){
                total += nums.get(i+1);
            }
            else{
                total -= nums.get(i+1);
            }
        }

        return total;
    }
    static void combination(int cnt, int[] oper_arr, int a, int b, int c, int d){
        if(cnt == N-1){ // 조합 다 했을때
            int total = cal_all(oper_arr);
            min = Math.min(min, total);
            max = Math.max(max, total);
            return ;
        }

        if(a > 0){
            oper_arr[cnt] = 0;
            combination(cnt+1, oper_arr, a-1, b, c, d);
        }
        if(b > 0){
            oper_arr[cnt] = 1;
            combination(cnt+1, oper_arr, a, b-1, c, d);
        }
        if(c > 0){
            oper_arr[cnt] = 2;
            combination(cnt+1,oper_arr, a, b, c-1, d);
        }
        if(d > 0){
            oper_arr[cnt] = 3;
            combination(cnt+1, oper_arr,a, b, c, d-1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 배열
        st = new StringTokenizer(br.readLine());
        int []oper_arr_count = new int[4];
        for(int i = 0; i < 4; i++){
            oper_arr_count[i] = Integer.parseInt(st.nextToken());
        }

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;


        combination(0, new int[N-1], oper_arr_count[0], oper_arr_count[1], oper_arr_count[2], oper_arr_count[3]);

        System.out.println(max);
        System.out.println(min);
    }
}