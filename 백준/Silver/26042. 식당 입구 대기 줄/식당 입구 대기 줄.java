import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		
		int max = 0;
		int last = n;
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int info = Integer.parseInt(st.nextToken());
			if(info == 1) {
				int a = Integer.parseInt(st.nextToken());
				q.add(a);
				if(max < q.size()) {
					max = q.size();
					last = a;
				}
				else if(max == q.size()) {
					last = last > a? a:last;
				}
			}
			else if(info == 2){
				q.poll();
			}
		}
		System.out.println(max + " " + last);
	}
}