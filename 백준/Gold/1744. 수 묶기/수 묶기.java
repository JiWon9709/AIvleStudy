import java.awt.Point;
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 양수일때 내림차순
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        // 음수일때 오름차순
        PriorityQueue<Integer> minus_pq = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++){
        	int n = Integer.parseInt(br.readLine());
        	if(n > 0)
        		pq.add(n);
        	else
        		minus_pq.add(n);
        }

        // 양수 : 가장 큰값 끼리 곱하기 / 1이면 더하기
        // 음수 : 가장 작은값 끼리 곱하기 / 0 이면 곱하기
        int total = 0;
    	while(pq.size() > 1) {

    		int a = pq.poll();
    		int b = pq.poll();
    		int sum = 0;
    		
    		if(a > 1 && b > 1) {
    			sum = a * b;
    		}
    		else sum = a + b;
    		total += sum;
        }
    	
    	while(!pq.isEmpty()) {
    		total += pq.poll();
    	}
    	
    	while(minus_pq.size() > 1) {
    		int a = minus_pq.poll();
    		int b = minus_pq.poll();
    		int sum = 0;
    		
    		sum = a * b;
    		total += sum;
    	}
    	
    	while(!minus_pq.isEmpty()) {
    		total += minus_pq.poll();
    	}
    	
    	System.out.println(total);
    }
}