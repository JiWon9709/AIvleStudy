import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] buildingOrder = new ArrayList[N+1]; // 선행 건물 인접리스트
        for(int i = 1; i <= N; i++){
            buildingOrder[i] = new ArrayList<>();
        }

        int [] buildTime = new int[N+1]; // 건물 짓는 시간
        int [] degree = new int[N+1]; // 위상 정렬 차수
        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int token = Integer.parseInt(st.nextToken());
                if(token == -1) break;
                // 먼저 지어져야할 건물 추가
                buildingOrder[token].add(i);
                degree[i]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();
        int [] sumTime = new int[N+1];
        for(int i = 1; i <= N; i++){
            if(degree[i] == 0){
                q.offer(i);
                sumTime[i] = buildTime[i];
            }
        }


        for(int i = 1; i <= N; i++){
            while(!q.isEmpty()){
                int cur = q.poll();

                for(int next: buildingOrder[cur]){
                    degree[next]--;
                    sumTime[next] = Math.max(sumTime[next], sumTime[cur] + buildTime[next]);
                    if(degree[next] == 0){
                        q.offer(next);
                    }
                }
            }
        }


        for(int i = 1; i <= N; i++){
            System.out.println(sumTime[i]);
        }
    }
}