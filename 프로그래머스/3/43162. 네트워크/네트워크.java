/**
1. 유니온 파인드로 개수 세기
2. dfs
*/
import java.util.*;

class Solution {
    static int ans;
    static int[] parents;
    
    static void union(int x, int y){
        int pa = find(x);
        int pb = find(y);
        
        if(pa < pb) parents[pb] = pa;
        else if(pb < pa) parents[pa] = pb;
    }
    
    static int find(int x){
        if(parents[x] == x) return x;
        return find(parents[x]);
    }
    
    public int solution(int n, int[][] computers) {
        ans = 0;
        parents = new int[n];
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j || computers[i][j] == 0) continue;
                if(computers[i][j] == 1){
                    if(find(i) != find(j))
                        union(i, j);
                }
            }
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            set.add(find(i));
        }
        return set.size();
    }
}