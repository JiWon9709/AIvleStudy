
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
//class SW3421_BurgerMaster_유지원 {
    static int[] input;
    static boolean[] isSelected;
    static int count;
    static int N, M;
    static ArrayList<int[]> pairs = new ArrayList<>();

    public static void subset(int idx) {
        if(idx == N) {
            for(int[] p : pairs){
                if(isSelected[p[0]-1] && isSelected[p[1]-1]) return;
            }
            count++;
            return;
        }
        // 선택 했을때
        isSelected[idx] = true;
        subset(idx+1);
        // 선택 안했을때
        isSelected[idx] = false;
        subset(idx+1);
    }

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            input = new int[N];
            isSelected = new boolean[N];
            for(int i = 0; i < N; i++) {
                input[i] = i + 1;
            }

            pairs.clear();
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // 주어지는 쌍들은 모두 다르지는 않고, 즉 같은 쌍이 여러 번 주어질 수도 있다.
                int[] pair = {a, b};
                pairs.add(pair);
//                boolean issamepair = false;
//                for(int[] p: pairs) {
//                    if ((p[0] == b && p[1] == a) || (p[0] == a && p[1] == b))
//                        issamepair = true;
//                        break;
//                }
//                if(!issamepair) pairs.add(pair);
            }

            count = 0;
            subset(0);

//            int subsetcnt = count;
//            int number_of_kinds = M == 0? fullcnt - subsetcnt*M : fullcnt - (subsetcnt*M - (M-1));
            System.out.println("#" + test_case+" "+ count);
        }
    }
}