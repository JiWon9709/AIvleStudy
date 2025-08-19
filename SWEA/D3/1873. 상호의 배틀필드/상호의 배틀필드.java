import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


class Solution
{
	/**
	 * 입력: map, 전차 위치, 바라보는 방향
	 * 출력: 바뀐 맵
	 *  
	 * 1. 포탄이 벽에 맞았을 경우,
	 * 1-1. 벽돌일 경우, 벽돌이 깨지고 평지가됨. * -> .
	 * 1-2. 강철일 경우, 아무일도 일어나지 않음.
	 * 1-3. 맵 밖으로 나갈 경우, 아무일도 일어나지 않음.
	 * 
	 * 2. 전차가 상하좌우를 바라볼 경우, 
	 * 2-1. 다음 칸이 평지라면 그 칸으로 이동.
	 * 2-2. 다음 칸이 물이라면 이동하지않음.
	 * 
	 */
	private static int T, H, W, N, d, cnt;
	private static int cur_x, cur_y;
	private static char[][] map;
	private static char[] input;	
	
	private static int[] dx = {0, -1, 0, 1}; // 우, 상, 좌, 하
	private static int[] dy = {1, 0, -1, 0};
	
	public static void print_map() {
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < W; j++) {
				if(i == cur_x && j == cur_y) {
					if(d == 0) {
						System.out.print('>');
					}
					else if(d == 1) {
						System.out.print('^');
					}
					else if(d == 2) {
						System.out.print('<');
					}
					else if(d == 3) {
						System.out.print('v');
					}
				}
				else System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void go(char x) {
		// 방향 바꾸기
		if(x == 'U') {
			d = 1;
		}
		else if(x == 'D') {
			d = 3;
		}
		else if(x == 'L') {
			d = 2;
		}
		else if(x == 'R') {
			d = 0;
		}
		// 맵 안에 있고, 한칸 이동 할수 있으면 이동.
		int move_x = cur_x + dx[d];
		int move_y = cur_y + dy[d];
		
		// 있던곳 평지로 만들고 이동
		if(move_x >= 0 && move_x < H && move_y >= 0 && move_y < W)
			if(map[move_x][move_y] == '.') {
				map[cur_x][cur_y] = '.';
				cur_x = move_x;
				cur_y = move_y;
		}
	}
	
	public static void shoot(int d) {
		int nx = cur_x + dx[d];
		int ny = cur_y + dy[d];
		// 바라보는 방향에 벽이 있는지 체크
		while(nx >= 0 && nx < H && ny >= 0 && ny < W) {
			// 평지일경우 이동
			if(map[nx][ny] == '.' || map[nx][ny] == '-') {
				nx += dx[d];
				ny += dy[d];
			}
			// 벽돌일 경우 부시기
			else if(map[nx][ny] == '*') {
				map[nx][ny] = '.';
				break;
			}
			else break; // 나머지일경우 멈춤
		}
	}
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			
			
			for(int i = 0; i < H; i++) {
				char[] line = br.readLine().toCharArray();
				for(int j = 0; j < W; j++) {
					map[i][j] = line[j];
					if(map[i][j] == '<') {
						d = 2;
						cur_x = i;
						cur_y = j;
					}
					else if(map[i][j] == '^') {
						d = 1;
						cur_x = i;
						cur_y = j;
					}
					else if(map[i][j] == '>') {
						d = 0;
						cur_x = i;
						cur_y = j;
					}
					else if(map[i][j] == 'v') {
						d = 3;
						cur_x = i;
						cur_y = j;
					}
				}
			}
			
			N = Integer.parseInt(br.readLine());
			input = br.readLine().toCharArray();
			// -- 입력 끝
			
			for(char c: input) {
				if(c == 'S') shoot(d);
				else go(c);
			}
			
            System.out.print("#" + test_case+" ");
            print_map();
		}
	}
}

/**
 * 

 */