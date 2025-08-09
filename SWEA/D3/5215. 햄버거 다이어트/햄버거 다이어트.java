import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Solution {
//public class SW5215_HamburgerDiet_유지원 {
    static boolean []isSelected;
    static ArrayList<int[]> ingredients_info;
    static int[] hamburgers;
    static int N, L;
    static int max_hamburger_score, ingredients_kcal_sum, ingredients_score_sum;

    public static void subset(int idx) {
        // 기저조건
        if(ingredients_kcal_sum > L) return;

        if(idx == N){
            ingredients_score_sum = 0;
            for(int i = 0; i < N; i++){
                if(isSelected[i])
                    ingredients_score_sum += ingredients_info.get(i)[0];
            }
            max_hamburger_score = Math.max(max_hamburger_score, ingredients_score_sum);
            return ;
        }

        isSelected[idx] = true;
        ingredients_kcal_sum += ingredients_info.get(idx)[1];
        subset(idx + 1);
        ingredients_kcal_sum -= ingredients_info.get(idx)[1]; // 원상복구

        isSelected[idx] = false;
        subset(idx + 1);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            isSelected = new boolean[N];
            hamburgers = new int[N];
            ingredients_info = new ArrayList<>();

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int kcal = Integer.parseInt(st.nextToken());

                int[] ingredient_info = {score, kcal};
                ingredients_info.add(ingredient_info);
            }

            max_hamburger_score = 0;
            ingredients_kcal_sum = 0;
            subset(0);
            System.out.println("#"+test_case+" "+ max_hamburger_score);
        }
    }
}
