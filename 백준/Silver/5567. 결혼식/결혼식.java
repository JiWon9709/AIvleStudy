import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
//public class JUN5567_WeddingCeremony_유지원 {
    static ArrayList<ArrayList<Integer>> friends;
    static int count = 0;
    static int n;
    static boolean[] isVisited;
    static int[] dists;

    public static void invite(int idx, int dist) {
        isVisited = new boolean[n+1];
        dists = new int[n+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(idx);
        isVisited[idx] = true;
        dists[idx] = dist;

        while (!q.isEmpty()){
            int cur = q.poll();

            for(int next: friends.get(cur)){
                if(isVisited[next]) continue;
                dists[next] = dists[cur]+1;

                if(dists[next] > 2) continue;

                isVisited[next] = true;
                count++;
                q.add(next);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        friends = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            friends.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        invite(1, 0);
        System.out.println(count);
    }
}
