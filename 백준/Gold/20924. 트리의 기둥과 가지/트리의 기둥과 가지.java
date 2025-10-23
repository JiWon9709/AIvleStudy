import java.io.*;
import java.util.*;

public class Main {
    static int n, max;
    static ArrayList<Edge>[] list;
    static boolean[] visited;
    static class Edge {
        int to, w;

        public Edge(int to, int w) {
            this.to = to;
            this.w = w;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "to=" + to +
                    ", w=" + w +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[from].add(new Edge(to, w));
            list[to].add(new Edge(from, w));
        }

        int giga = 0;
        int gidung = 0;

        int parent = 0;
        int cur = r;
        int next = 0;
        int weight = 0;
        while(true){
            int child = 0; // 자식 개수를 세기 위한 변수

            for(Edge e : list[cur]) {
                if(e.to == parent) continue;
                child++;
                next = e.to;
                weight = e.w;
            }

            // 자식의 개수가 1이 아니면 기가노드
            if (child != 1) {
                giga = cur;
                break;
            }
            // 자식의 수가 1개 이면 전진
            parent = cur;
            cur = next;
            gidung += weight;
        }
        String ans = "";
        ans += gidung;
        ans += " ";

        visited = new boolean[n+1];
        max = 0;
        visited[giga] = true;
        // 부모방향 막기
        if(parent != 0) visited[parent] = true;
        dfs(giga, 0);
        System.out.println(ans + max);
    }
    static void dfs(int start, int val){
        boolean isleaf = true; // 다음 노드가 없으면 리프노드
        // 다음 노드에 방문하지 않았을때,
        // val 추가하고, 리프노드까지 연결된 다음 노드로 방문
        for(Edge e: list[start]){
            if(!visited[e.to]){
                visited[e.to] = true;
                isleaf = false;
                dfs(e.to, val+e.w);
                visited[e.to] = false;
            }
        }
        if(isleaf){
            max = Math.max(max, val);
        }
    }
}
