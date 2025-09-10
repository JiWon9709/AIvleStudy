import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, E;
    static ArrayList<Integer>[] graph;
    static int [] color;

    static boolean bfs(int x) {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(x);
        color[x] = 1;

        while(!q.isEmpty()){
            int row = q.poll();

            for(int col : graph[row]) {
                if(color[col] == color[row]) return false;
                if(color[col] == 0){
                    color[col] = color[row] * -1;
                    q.offer(col);
                }
            }
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V+1];
            for(int i = 1; i <= V; i++){
                graph[i] = new ArrayList<>();
            }

            for (int edge_idx = 0; edge_idx < E; edge_idx++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                graph[r].add(c);
                graph[c].add(r);
            }

            color = new int[V + 1];
            boolean isbipartite = true;
            for(int i = 1; i <= V; i++){
                if(color[i] == 0) {
                    if (!bfs(i)) {
                        isbipartite = false;
                        break;
                    }
                }
            }

            if (isbipartite) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}