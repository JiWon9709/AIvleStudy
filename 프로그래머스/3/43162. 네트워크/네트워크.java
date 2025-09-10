/**
1. 유니온 파인드로 개수 세기
2. dfs
*/
import java.util.*;

class Solution {
    
    void dfs(int x, int[][] computers, boolean []visited){
        for(int i =0; i < computers.length; i++){
            if(!visited[i] && computers[x][i] == 1){
                visited[i] = true;
                dfs(i, computers, visited);
            }
        }
        
    }
    
    public int solution(int n, int[][] computers) {
        int cnt = 0;
        boolean []visited = new boolean[n];
        
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, computers, visited);
                cnt++;
            }
        }
        return cnt;
    }
}