import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	static int n;
//	static long cnt; // 전역변수로 선언하면 중복으로 더할수있으므로 과대 계산이 일어남
	static long[] arr, tmp;
	
	static long merge_sort(int s, int e) {
		if(s >= e) return 0; // swap 할거 없기때문에 return
		
		int start = s;
		int mid = (s + e) >>> 1;
		int end = e;
		long cnt = 0;
		
		cnt += merge_sort(start, mid);
		cnt += merge_sort(mid+1, end);
		
		int i = start;
		int j = mid+1;
		int k = start; // tmp 배열의 시작 인덱스 = s와 같음
		
		while(i <= mid && j <= end) {
			if(arr[i] <= arr[j]) { // 왼쪽이 더 작기때문에 왼쪽 원소 tmp 배열에 복사, 같은것도 그냥 복사
				tmp[k++] = arr[i++];
			}
			else { // 역순쌍이므로 swap
				cnt += (mid - i + 1);
				tmp[k++] = arr[j++];
			}
		}
		
		// 잔여분 복사. 왼쪽이 더 작기때문에 왼쪽부터 복사
		while(i <= mid) tmp[k++] = arr[i++];
		while(j <= end) tmp[k++] = arr[j++];
		
		// sort한 tmp 배열을 원본배열에 복사 
		for(int idx = s; idx <= e; idx++) {
			arr[idx] = tmp[idx];
		}
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr = new long[n];
		tmp = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(st.nextToken());
		}
		
		System.out.println(merge_sort(0, n-1));
	}
}