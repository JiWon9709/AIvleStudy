import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
최소 스패닝 트리 mst
모든 정점을 연결하는 부분 그래프 중 가중치의 합이 최소

크루스칼 - 간선 기준
3 3
1 2 1
2 3 2
1 3 3
--
pq = [1, 2, 3]
1 + 2 = 3
3
 */

public class Main {
    static int V, E;
    static class Edge implements Comparable<Edge>{
        int start;
        int end;
        int weight;

        @Override
        public int compareTo(Edge o) {
            return (int)(this.weight - o.weight);
        }

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        ArrayList<Edge>[] nodelist = new ArrayList[V+1];
        for(int i = 0; i <V+1; i++){
            nodelist[i] = new ArrayList<>();
        }

        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            nodelist[start].add(new Edge(start, end, weight));
            nodelist[end].add(new Edge(end, start, weight));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 1, 0));
        int minCost = 0;
        boolean visited[] = new boolean[V+1];
        int edgecnt = 0;

        while (edgecnt <= V-1){
            Edge e = pq.poll();
            int end = e.end;
            int weight = e.weight;

            if(visited[end]) continue;
            visited[end] = true;
            minCost += weight;
            edgecnt++;

            for(int i = 0; i < nodelist[end].size(); i++){
                pq.add(nodelist[end].get(i));
            }
        }
        System.out.println(minCost);
    }
}
