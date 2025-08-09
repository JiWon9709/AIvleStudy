import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
//public class JUN1325_Hacking_유지원 {
    static int N, cnt;
    static ArrayList<ArrayList<Integer>> computers;
    static int[] hacking_cnt;
    static boolean[] isSelected;

    public static int hacking_computer(int idx){
        isSelected = new boolean[N+1];
        Queue<Integer> q = new ArrayDeque<>();
        isSelected[idx] = true;
        q.add(idx);
        int count = 1;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next: computers.get(cur)){
                if(!isSelected[next]){
                    isSelected[next] = true;
                    count++;
                    q.add(next);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        computers = new ArrayList<>();
        for(int i = 0; i <= N; i++){
            computers.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            // B를 해킹하면 A도 해킹가능
            computers.get(B).add(A);
        }
        hacking_cnt = new int[N+1];
        isSelected = new boolean[N+1];
        Queue<Integer> q = new ArrayDeque<>();

        int max = 0;
        // 컴퓨터 번호 하나씩 최대 해킹 구하기
        for(int i =1; i <= N; i++){
            cnt = 0;
            hacking_cnt[i] = hacking_computer(i);
            max = Math.max(max, hacking_cnt[i]);
        }

//        System.out.println(Arrays.toString(hacking_cnt));
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            if(max == hacking_cnt[i])
                sb.append(i).append(" ");
        }
        System.out.print(sb);
    }
}
