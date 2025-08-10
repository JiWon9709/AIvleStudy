//package study.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int[] parents;

    public static ArrayList<Integer> find_parent(int node) {
        ArrayList<Integer> arr_parents = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        arr_parents.add(node);
        stack.add(parents[node]);

        while(!stack.isEmpty()){
            int cur_node = stack.pop();
            arr_parents.add(cur_node);
            if(parents[cur_node] > 0) stack.add(parents[cur_node]);
        }
        return arr_parents;
    }

    public static int find_near_parent(ArrayList<Integer> arr_parents_n1, ArrayList<Integer> arr_parents_n2){
        int nearest_node = 0;

        for(int y: arr_parents_n2){
            if(nearest_node > 0) break;
            for(int x: arr_parents_n1){
                if(x == y) {
                    nearest_node = x;
                    break;
                }
            }
        }
        return nearest_node;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 0; test_case < T; test_case++){
            int N = Integer.parseInt(br.readLine());
            parents = new int[N+1];

            for(int edge = 0; edge < N-1; edge++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                parents[child] = parent;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            int findn1 = Integer.parseInt(st.nextToken());
            int findn2 = Integer.parseInt(st.nextToken());

            System.out.println(find_near_parent(find_parent(findn1), find_parent(findn2)));
        }
    }

}
